package com.course.muke.cases.casecollection;

import com.course.pageobject.cases.LoginCase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNgListenerScreen extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("case执行失败");
        LoginCase lc = (LoginCase)iTestResult.getInstance();
        WebDriver driver = lc.driver;
        try {
            this.takeScreenShot(driver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        super.onTestFailure(iTestResult);
    }

    public void takeScreenShot(WebDriver driver) throws FileNotFoundException {

        if(driver == null) {
            return;
        }

        if(!(driver instanceof TakesScreenshot)){
            return;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_ss");
        String curTime = dateFormat.format(new Date());

        //String clsName = this.getClass().getName();
        String pngName = curTime + ".png";

        String curPath = System.getProperty("user.dir");
        System.out.println(curPath);
        String dirPath = "src/main/java/com/course/muke/cases/log/";
        File dir = new File(dirPath);
        if(!dir.exists()){
            boolean mkdirResult = dir.mkdirs();
            if(!mkdirResult){
                System.err.println("警告：创建截图目录失败，请检查权限或路径。");
            }
            dir.mkdirs();
        }


        try {
            File logFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            if(logFile == null || !logFile.exists()) {
                System.err.println("截图失败：Selenium 返回的临时文件为 null 或不存在。浏览器可能已崩溃。");
                return;
            }
            String destPath = dirPath + pngName;

            Files.copy(logFile.toPath(), Paths.get(destPath),StandardCopyOption.REPLACE_EXISTING);
            System.out.println("截图保存成功: " + new File(destPath).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("截图过程中发生异常: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            e.printStackTrace();
        }
    }
}

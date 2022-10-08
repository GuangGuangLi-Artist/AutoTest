package com.course.muke.cases.casecollection;

import com.course.pageobject.cases.LoginCase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.reporters.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_ss");
        String curTime = dateFormat.format(new Date());

        //String clsName = this.getClass().getName();
        String pngName = curTime + ".png";

        String curPath = System.getProperty("user.dir");
        System.out.println(curPath);
        File logFile = ((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
        FileInputStream fis = new FileInputStream(logFile);
        try {
            Files.copyFile(fis,new File("src/main/java/com/course/muke/cases/log/" + pngName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

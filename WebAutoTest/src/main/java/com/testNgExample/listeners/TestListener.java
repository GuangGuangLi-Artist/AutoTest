package com.testNgExample.listeners;

import com.testNgExample.driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[开始] 执行测试: " + result.getMethod().getMethodName());

    }


    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[成功] 测试通过: " + result.getMethod().getMethodName());
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[失败] 测试失败: " + result.getName());
        try {
            takeScreenshot(result);
        } catch (Exception e) {
            // 如果连 Driver 都拿不到，说明环境严重错误，只记录日志，不阻断流程
            String errorMsg = String.format(
                    "[%s] 警告：无法截取失败截图 - %s (原因: %s)",
                    Thread.currentThread().getName(),
                    result.getName(),
                    e.getMessage()
            );
            System.err.println(errorMsg);
        }
    }

    private void takeScreenshot(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) {
            throw new RuntimeException("当前线程 [" + Thread.currentThread().getName() + "] 未找到 WebDriver 实例！" +
                    "可能原因：@BeforeMethod 未执行或 DriverFactory 未正确初始化 ThreadLocal。");
        }

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            // 这里可以添加保存文件到磁盘的逻辑，例如：
            // File srcFile = new File("screenshots/" + result.getName() + "_" + System.currentTimeMillis() + ".png");
            // FileUtils.writeByteArrayToFile(srcFile, screenshot);

            System.out.println("[" + Thread.currentThread().getName() + "] 成功截取失败截图: " + result.getName() + " (大小: " + screenshot.length + " bytes)");


        } catch (ClassCastException e) {
            // 【核心修复】捕获所有异常，确保监听器出错不影响测试主流程
            throw new RuntimeException("当前的 WebDriver 实例不支持截图操作 (未实现 TakesScreenshot 接口)", e);
        } catch (Exception e) {
            throw new RuntimeException("截图过程中发生未知错误", e);
        }

    }
}

package com.course.pageobject.exceptionListener;

import com.course.pageobject.utils.InitDriver;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger log = LoggerFactory.getLogger(TestListener.class);
    private


     WebDriver getDriver(ITestResult result) {
        Object testClassInstance = result.getInstance();
        if (testClassInstance instanceof InitDriver) {
            return ((InitDriver) testClassInstance).getDriver("chrome");
        }
        return null;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult result) {


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

}

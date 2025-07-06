package com.course.code;

import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.net.MalformedURLException;

import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAppiumRecord {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        Capabilities options = new BaseOptions()
                .amend("platformName", "android")
                .amend("appium:deviceName", "liguang")
                .amend("appium:appPackage", "com.xueqiu.android")
                .amend("appium:appActivity", ".view.WelcomeActivityAlias")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(this.getUrl(), options);
    }

    @Test
    public void testAppiumRecord() {
        // This sample code supports Appium Java client >=9
        // https://github.com/appium/java-client
        WebElement el1 = driver.findElement(AppiumBy.id("com.xueqiu.android:id/tv_agree"));
        el1.click();

    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private URL getUrl() {
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723");
            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

}

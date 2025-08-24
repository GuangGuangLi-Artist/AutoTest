package com.course.code.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestAppiumApkDemo {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        Capabilities options = new BaseOptions()
                .amend("platformName", "android")
                .amend("appium:deviceName", "2KE0219B16095137")
                .amend("appium:appPackage", "io.appium.android.apis")
                .amend("appium:appActivity", ".ApiDemos")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:autoGrantPermissions", true)
                .amend("appium:automationName","UiAutomator2");



        driver = new AndroidDriver(this.getUrl(), options);
    }

    /**
     *
     */

    @Test
    public void testAppiumApiToast() {
        driver.findElement(new AppiumBy.ByAccessibilityId("Views")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Popup Menu\"))")).click();
        driver.findElement(new AppiumBy.ByAccessibilityId("Make a Popup!")).click();
        driver.findElement(By.xpath("//*[@text='Search']")).click();
        String text = driver.findElement(By.xpath("//*[@Class='android.widget.Toast']")).getText();
        System.out.println(text);


    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    private URL getUrl() {
        URL url = null;
        try {
            url = new  URL("http://127.0.0.1:4723");
            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }



}
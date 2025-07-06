package com.course.code;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestAppiumDemo {

    @Test
    public void testAppiumDemo() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("/data/app/~~aKgyYpjtO-8coQSdmD-MIg==");
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(
                    // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                    new URL("http://127.0.0.1:4723/wd/hub"), options
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            WebElement el = driver.findElement(AppiumBy.id("com.xueqiu.android:id/home_search"));
            el.click();
            driver.getPageSource();
        } finally {
            driver.quit();
        }

    }
}
package com.course.code.test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;

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
                .amend("appium:deviceName", "2KE0219B16095137")
                .amend("appium:appPackage", "com.xueqiu.android")
                .amend("appium:appActivity", ".view.WelcomeActivityAlias")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:automationName","UiAutomator2")
                .amend("appium:unicodeKeyboard", true)//支持输入中文
                .amend("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(this.getUrl(), options);
    }

    @Test
    public void testAppiumRecord() {
        // This sample code supports Appium Java client >=9
        // https://github.com/appium/java-client
        WebElement el1 = driver.findElement(AppiumBy.id("com.xueqiu.android:id/tv_agree"));
        //TouchAction action = new TouchAction(driver);
        //action.tap().press().longPress().release().moveTo().perform().cancel();
        el1.click();

    }


    /**
     * 常用设备交互命令
     */
    @Test
    public void testQueryAppState(){
        ApplicationState state = driver.queryAppState("com.xueqiu.android");
        System.out.println(state.toString());//RUNNING_IN_FOREGROUND

    }

    @Test
    public void testPerformance(){
        List<String> list = driver.getSupportedPerformanceDataTypes();
        for (String s : list) {
            List<List<Object>> data = driver.getPerformanceData("com.xueqiu.androi", s, 5);
                try {
                    for (List<Object> list1 : data) {
                        for (Object o : list1) {
                            System.out.println(o.toString());
                        }
                    }
                }catch (Exception e){
                    throw e;
                }

        }
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

package com.course.code.cases;

import com.course.code.pages.firstPage.SnowBallFirstPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SearchCase {

    private AndroidDriver driver;


    @BeforeClass
    public void setUp() {
        Capabilities capabilities = new BaseOptions()
                .amend("platformName", "android")
                .amend("appium:deviceName", "2KE0219B16095137")
                .amend("appium:appPackage", "io.appium.android.apis")
                .amend("appium:appActivity", ".ApiDemos")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
//                .amend("appium:autoGrantPermissions", true)
//                .amend("appium:autoAcceptAlerts",true)//自动接收弹框为true
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:noReset", true)
                .amend("appium:shouldTerminateApp", true);


        driver = new AndroidDriver(this.getUrl(), capabilities);
        //解决弹框 ，进入到apidemo


    }


    @Test
    public void testSerach(){
//        SnowBallFirstPage sfPage = new SnowBallFirstPage(driver);
//        //adb shell pm clear io.appium.android.apis 清空缓存
        //添加显示等待
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement continueButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/continue_button\"]")));
        continueButton.click();
        WebElement confirmButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")));
        confirmButton.click();
        WebElement contentElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Content\"]")));
        contentElement.click();
        WebElement assetsElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Assets\"]")));
        assetsElement.click();
        WebElement readAssetsButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Read Asset\"]")));
        readAssetsButton.click();
        WebElement  assetsTextElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("io.appium.android.apis:id/text")));
        String string = assetsTextElement.getText();
        System.out.println(string);
        boolean contains = StringUtils.contains(string, "This text is stored in a raw Asset");
        Assert.assertTrue(contains);


    }

    @AfterClass
    public void teardown(){
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

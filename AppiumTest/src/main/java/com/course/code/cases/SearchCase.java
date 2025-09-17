package com.course.code.cases;

import com.course.code.pages.firstPage.SnowBallFirstPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.Capabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

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


    }


    @Test
    public void testSerach(){
        SnowBallFirstPage sfPage = new SnowBallFirstPage(driver);

        //adb shell pm clear io.appium.android.apis 清空缓存
        sfPage.clickContinueButton();
        sfPage.clickConfirmButton();
        sfPage.clickContentButton();
        sfPage.clickAssetsButton();
        sfPage.clickReadAssetsButton();
        String content = sfPage.getAssetsTextButtonContent();
        Assert.assertEquals(content,"This text is stored in a raw Asset.\\n\\nIt was read and placed into the TextView here.\\n");


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

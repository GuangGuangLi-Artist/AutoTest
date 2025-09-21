package com.course.code.cases;

import com.course.code.pages.assetpages.AssetPages;
import com.course.code.pages.assetsTextPages.AssetsTextPage;
import com.course.code.pages.confirmPages.ConfirmPage;
import com.course.code.pages.contentPages.ContentPage;
import com.course.code.pages.permissonPages.PermissonPage;
import com.course.code.pages.readAssertPages.ReadAssertPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.apache.commons.lang3.StringUtils;
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
    public void testSerach() {
//        //adb shell pm clear io.appium.android.apis 清空缓存

        PermissonPage permissonPage = new PermissonPage(driver);
        permissonPage.clickContinueButton();

        ConfirmPage confirmPage = new ConfirmPage(driver);
        confirmPage.clickOnConfirmButton();

        ContentPage contentPage = new ContentPage(driver);
        contentPage.clickContentButton();

        AssetPages assetPages = new AssetPages(driver);
        assetPages.clickAsset();

        ReadAssertPage readAssertPage = new ReadAssertPage(driver);
        readAssertPage.clickReadAsset();

        AssetsTextPage assetsTextPage = new AssetsTextPage(driver);
        String string = assetsTextPage.getAssetsTextPageText();
        System.out.println(string);
        boolean contains = StringUtils.contains(string, "This text is stored in a raw Asset");
        Assert.assertTrue(contains);


    }

    @AfterClass
    public void teardown() {
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

package com.course.code.pages.firstPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class SnowBallFirstPage {


    private static final Logger logger = LoggerFactory.getLogger(SnowBallFirstPage.class);


    private WebElement continueButton;
    private WebElement confirmButton;
    private WebElement contentElement;
    //private WebElement agree;
    private WebElement assetsElement;
    private WebElement readAssetsButton;
    private WebElement assetsTextElement;


    public SnowBallFirstPage(AndroidDriver driver) {
        //// 点击 Animation
        WebDriverWait waitD = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.contentElement = waitD.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("content")));

        this.assetsElement = driver.findElement((AppiumBy.accessibilityId("Assets")));
        this.readAssetsButton = driver.findElement((AppiumBy.accessibilityId("Read Asset")));
        this.assetsTextElement = driver.findElement((AppiumBy.id("io.appium.android.apis:id/text")));

//        this.agree = driver.findElement(AppiumBy.accessibilityId("Animation"));

    }


    //点击
    public void clickContinueButton() {
        logger.info("点击继续按钮");
        this.continueButton.click();
    }

    public void clickConfirmButton() {
        logger.info("点击确定");
        this.confirmButton.click();
    }

    public void clickContentButton() {
        logger.info("点击content");
        this.contentElement.click();
    }

    public void clickAssetsButton() {
        logger.info("点击assets");
        this.assetsElement.click();
    }

    public void clickReadAssetsButton() {
        logger.info("点击readasserts 获取内容");
        this.readAssetsButton.click();

    }

    public String getAssetsTextButtonContent() {
        logger.info("获取AssetsText文本");
        return this.assetsTextElement.getText();
    }


//    public void search() {
//        agree.click();
//
//    }
}

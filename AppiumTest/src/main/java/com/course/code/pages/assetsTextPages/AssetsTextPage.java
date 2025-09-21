package com.course.code.pages.assetsTextPages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AssetsTextPage {

    private static final Logger logger = LoggerFactory.getLogger(AssetsTextPage.class);
    private WebElement assetTextElement;

    public AssetsTextPage(WebDriver driver) {
        logger.info("AssetsTextPage Constructor");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.assetTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("io.appium.android.apis:id/text")));
    }

    public String getAssetsTextPageText() {
        logger.info("AssetsTextPage getText");
        return assetTextElement.getText();
    }
}

package com.course.code.pages.assetpages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AssetPages {
    private static final Logger logger = LoggerFactory.getLogger(AssetPages.class);
    private WebElement assetElement;

    public AssetPages(WebDriver driver) {
        logger.info("AssetPages Constructor");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.assetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Assets\"]")));
    }

    public void clickAsset() {
        logger.info("Click Asset");
        assetElement.click();
    }
}

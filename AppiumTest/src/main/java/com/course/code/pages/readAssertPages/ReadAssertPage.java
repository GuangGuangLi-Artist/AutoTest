package com.course.code.pages.readAssertPages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ReadAssertPage {

    private static final Logger logger = LoggerFactory.getLogger(ReadAssertPage.class);
    private WebElement readAssetElement;

    public ReadAssertPage(WebDriver driver) {
        logger.info("ReadAssertPages Constructor");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.readAssetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Read Asset\"]")));
    }

    public void clickReadAsset() {
        logger.info("click  readAssetElement");
        readAssetElement.click();
    }


}

package com.course.code.pages.contentPages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ContentPage {
    private static final Logger logger = LoggerFactory.getLogger(ContentPage.class);
    private WebElement contentButton;

    public ContentPage(WebDriver driver) {
        logger.info("ContentPage");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.contentButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Content\"]")));

    }

    public void clickContentButton() {
        logger.info("clickContentButton");
        this.contentButton.click();
    }


}

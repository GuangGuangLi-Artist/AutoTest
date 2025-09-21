package com.course.code.pages.confirmPages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ConfirmPage {
    private static final Logger logger = LoggerFactory.getLogger(ConfirmPage.class);
    private WebElement confirmButton;

    public ConfirmPage(WebDriver driver) {
        logger.info("PermissonPage");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")));

    }

    public void clickOnConfirmButton() {
        logger.info("clickOnConfirmButton");
        this.confirmButton.click();
    }
}

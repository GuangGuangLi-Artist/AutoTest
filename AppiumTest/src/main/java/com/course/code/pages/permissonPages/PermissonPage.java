package com.course.code.pages.permissonPages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class PermissonPage {
    private static final Logger logger = LoggerFactory.getLogger(PermissonPage.class);
    private WebElement continueButton;

    public PermissonPage(AndroidDriver driver) {
        logger.info("PermissonPage");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/continue_button\"]")));


    }

    public void clickContinueButton() {
        logger.info("clickContinueButton");
        this.continueButton.click();
    }

}

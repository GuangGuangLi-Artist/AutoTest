package com.course.code.pages.firstPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;



public class SnowBallFirstPage {

    private WebElement agree;

    public SnowBallFirstPage(AndroidDriver driver) {
        //// 点击 Animation
        this.agree = driver.findElement(AppiumBy.accessibilityId("Animation"));

    }


    public void search() {
        agree.click();

    }
}

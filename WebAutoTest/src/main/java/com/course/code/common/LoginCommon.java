package com.course.code.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginCommon {
    public static void login(WebDriver driver, String username, String password){
        driver.findElements(By.name("tj_login")).get(1).click();
        driver.findElement(By.id("TANGRAM__PSP_11__changePwdCodeItem")).click();
        driver.findElement(By.name("userName")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("TANGRAM__PSP_11__submit")).click();
    }
}



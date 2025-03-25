package com.course.pageobject.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitDriver {


    WebDriver driver;
    public WebDriver getDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }else {
            System.setProperty("webdriver.gecko.driver","src/main/resources/geckoriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }
}

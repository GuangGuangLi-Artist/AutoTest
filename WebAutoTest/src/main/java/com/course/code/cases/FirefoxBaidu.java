package com.course.code.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBaidu {
    public static void main(String[] args) {

        System.setProperty("webdriverfirefox","D:\\software\\IDM\\IDM\\BaiDuPanZhuanYong\\Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("kw")).sendKeys("selenium.java");
        driver.findElement(By.id("su")).click();
        driver.close();
    }
}

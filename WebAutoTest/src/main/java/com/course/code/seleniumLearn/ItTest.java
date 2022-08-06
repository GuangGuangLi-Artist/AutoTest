package com.course.code.seleniumLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ItTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("控制浏览器前进后退");
        driver.get("http://www.baidu.com");
        System.out.println("第一个地址请求成功");
        driver.get("http://news.baidu.com");
        System.out.println("第二个地址请求成功");

        System.out.println("开始后退到第一个地址");
        driver.navigate().back();
        System.out.println("开始前进到第二个地址");
        driver.navigate().forward();

        driver.navigate().back();

        WebElement element = driver.findElement(By.id("kw"));
        driver.findElement(By.id("kw")).sendKeys("selenium java");
        System.out.println(element);
        driver.findElement(By.id("su")).click();
        driver.close();
    }
}

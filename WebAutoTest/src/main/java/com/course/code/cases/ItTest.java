package com.course.code.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ItTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
        driver.close();
    }
}

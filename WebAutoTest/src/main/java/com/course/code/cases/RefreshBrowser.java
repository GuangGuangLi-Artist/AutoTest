package com.course.code.cases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RefreshBrowser {

    @Test
    public void refreBrowser() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1500,2000));//尺寸 单元
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.close();


    }
}

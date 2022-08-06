package com.course.code.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * 简单元素操作
 * clear() 清除文本。
 * sendKeys(*value) 模拟按键输入。
 *  click() 单击元素
 *  submit() 提交表单
 */
public class Login126 {

    @Test
    public void login126() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1500,2000));//尺寸 单元
        driver.get("https://mail.163.com/");

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("15607521232");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("12345678@x");
        driver.findElement(By.id("dologin")).click();

        Thread.sleep(3000);
        driver.close();

    }

    @Test
    public void youDao() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1500,2000));//尺寸 单元
        driver.get("https://www.youdao.com/");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("有道");
        driver.findElement(By.xpath("//a[@class='translate_btn']")).click();
        Thread.sleep(2000);
        driver.close();



    }
}

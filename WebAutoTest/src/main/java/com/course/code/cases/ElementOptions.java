package com.course.code.cases;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * 简单元素操作
 * clear() 清除文本。
 * sendKeys(*value) 模拟按键输入。
 *  click() 单击元素
 *  submit() 提交表单
 */
public class ElementOptions {

    /**
     * getSize() 返回元素的尺寸。
     * getText() 获取元素的文本。
     * getAttribute(name) 获得属性值。
     * isDisplayed() 设置该元素是否用户可见。
     */
    @Test
    public void seleniumoption1(){
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(1500,2000));//尺寸 单元
        driver.get("http://www.baidu.com");


//        获取百度输入框尺寸
        WebElement size = driver.findElement(By.id("kw"));
        System.out.println(size.getSize());

//        返回百度页面底部备案信息
        WebElement text = driver.findElement(By.xpath("//div[@id='bottom_layer']/div/p[6]"));
        System.out.println(text.getText());
//        返回元素的属性值
        WebElement ty = driver.findElement(By.id("kw"));
        System.out.println(ty.getAttribute("name"));

//        返回元素结果是否可见
        WebElement display = driver.findElement(By.id("kw"));
        System.out.println(display.isDisplayed());

        driver.close();


    }

    /**
     * 鼠标事件
     * contextClick() 右击
     * clickAndHold() 鼠标点击并控制
     * doubleClick() 双击
     * dragAndDrop() 拖动
     *  release() 释放鼠标
     * perform() 执行所有 Actions 中存储的行为
     *
     * drag_and_drop(source, target)在源元素上按下鼠标左键，然后移动到目标元素上释放。
     *       source：鼠标拖动的源元素。
     *       target：鼠标释放的目标元素。
     */

   @Test
    public  void seleniumoption2(){
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(1500,2000));//尺寸 单元
        driver.get("http://www.baidu.com");

        //鼠标悬停
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.id("s-usersetting-top"))).perform();
        driver.close();

    }


    /**
     * 键盘事件
     */
    @Test
    public void keyboard(){
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(1500,2000));//尺寸 单元
        driver.get("http://www.baidu.com");
        WebElement input = driver.findElement(By.id("kw"));

        //输入框输入内容
        input.sendKeys("seleniumm");

        //删除多输入的一个m
        input.sendKeys(Keys.BACK_SPACE);

        //输入空格+教程
        input.sendKeys(Keys.SPACE);
        input.sendKeys("教程");

//        ctrl +a 全选输入框内容
        input.sendKeys(Keys.CONTROL,"a");

//        剪切输入框内容
        input.sendKeys(Keys.CONTROL,"x");
//        ctrl +v 粘贴内容到输入框
        input.sendKeys(Keys.CONTROL,"v");

        driver.close();
    }


    /** 获得验证消息
     * getTitle()：用于获得当前页面的 title。
     * getCurrentUrl() ：用户获得当前页面的 URL
     *  getText() 获取用户文本
     */


    @Test
    public void titleUrl() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(1500,2000));//尺寸 单元
        driver.get("http://www.baidu.com");


        System.out.println("当前页面title:" + driver.getTitle());
        System.out.println("当前页面URL" + driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.close();
    }

    /**
     * 设置元素等待
     * timeouts 方法
             *  implicitlyWait。识别对象时的超时时间。过了这个时间如果对象还没找到的话就会抛出NoSuchElement 异常。
             * setScriptTimeout。异步脚本的超时时间。WebDriver 可以异步执行脚本，这个是设置异步执行脚本脚本返回结果的超时时间。
             * pageLoadTimeout。页面加载时的超时时间。因为 WebDriver 会等页面加载完毕再进行后面的操作，所以如果页面超过设置时间依然没有加载完成，那么 WebDriver 就会抛出异常。
     *
     * sleep 休眠方法
     *      Thread.sleep()方法
     */

    @Test
    public void timeOut(){
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {

            //driver.manage().window().setSize(new Dimension(1500,2000));//尺寸 单元
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);//页面超时时间限制为5s
            driver.get("http://www.baidu.com");

            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//定位对象时给10s的时间，如果超过10s就抛出异常
            driver.findElement(By.id("kw33")).sendKeys("selenium");

            driver.manage().timeouts().setScriptTimeout(3,TimeUnit.SECONDS);//异步脚本的超时时间设置为3s

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }


}

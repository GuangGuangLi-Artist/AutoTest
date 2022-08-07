package com.course.code.cases;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;
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


    /**
     * 多窗口切换
     * switchTo().frame()
     *
     * 定位动态id的元素
     * driver.find_element_by_xpath
     * ("//div[contains(@id, 'btn-attention')]")
     * driver.find_element_by_xpath
     * ("//div[starts-with(@id, 'btn-attention')]")
     * driver.find_element_by_xpath
     * ("//div[ends-with(@id, 'btn-attention')]")
     *
     * # 这个需要结尾是‘btn-attention’
     * contains(a, b) 如果a中含有字符串b，则返回true，否则返回false
     * starts-with(a, b) 如果a是以字符串b开头，返回true，否则返回false
     * ends-with(a, b) 如果a是以字符串b结尾，返回true，否则返回false
     *
     * 定位动态id的iframe的第二种方法
     * 定位他的父级固定的元素，然后再定位到下级元素如下
     * //div[@id="loginDiv"]/iframe
     *
     */

    @Test
    public void swichFrame() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
        //方式一：定位id为动态的iframe
        WebElement ifrme = driver.findElement(By.xpath("//iframe[starts-with(@id,'x-URS-iframe')]"));
        driver.switchTo().frame(ifrme);
        //方式2
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id,'x-URS-iframe')]")));

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("15607521111");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("12345678&*");
        driver.findElement(By.id("dologin")).click();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        Thread.sleep(30000);
        driver.quit();

    }


    /**
     * 多窗口切换
     *
     * 在页面操作过程中有时候点击某个链接会弹出新的窗口，这时就需要主机切换到新打开的窗口上进行操作
     *  getWindowHandle()：获得当前窗口句柄。
     * getWindowHandles()：返回的所有窗口的句柄到当前会话。
     * switchTo().window()：用于切换到相应的窗口，与上一节的 switchTo().frame()类似
     *
     */

    @Test
    public void swichWindows() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");

        //获得当前窗口句柄
        String search_handle = driver.getWindowHandle();

        //打开百度注册窗口
        System.out.println(search_handle);
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("立即注册")).click();

        //获取所有窗口句柄
        Set<String> handles = driver.getWindowHandles();

        //判断是否为注册窗口，并操作注册窗口上的元素
        for (String handle:handles){
            if(handle.equals(search_handle)==false){
                //切换到注册页面
                driver.switchTo().window(handle);
                System.out.println("现在是注册页面窗口");
                Thread.sleep(3000);
                driver.findElement(By.name("userName")).clear();
                driver.findElement(By.name("userName")).sendKeys("userName15607");
//                driver.findElement(By.name("phone")).clear();
//                driver.findElement(By.name("phone")).sendKeys("12345678901");
//                driver.findElement(By.name("password")).clear();
//                driver.findElement(By.name("password")).sendKeys("123456@33");
//                driver.findElement(By.name("submit")).submit();
                Thread.sleep(3000);
                driver.close();
            }
        }

        //判断是否为百度首页，并操作首页上的元素
        for (String handle:handles){
            if(handle.equals(search_handle)){
                //切换到百度首页页面
                driver.switchTo().window(handle);
                Thread.sleep(3000);
                driver.findElement(By.className("close-btn")).click();
                System.out.println("这是百度首页");
                driver.findElement(By.id("kw")).sendKeys("hello world");
                driver.findElement(By.id("su")).click();
                Thread.sleep(3000);

            }
        }
        driver.close();




    }

    /**
     * 警告框处理
     *
     * 在 WebDriver 中处理JavaScript所生成的alert 、confirm以及 prompt十分简单，具体做法是使用
     * switch_to_alert()方法定位到 alert/confirm/prompt，然后使用 text/accept/dismiss/ sendKeys 等方法进行操作。
     * getText()：返回 alert/confirm/prompt 中的文字信息。
     * accept()： 接受现有警告框。
     * dismiss()：解散现有警告框。
     * sendKeys(keysToSend)：
     * 发送文本至警告框。keysToSend：将文本发送至警告框。
     */

    @Test
    public void alertHandle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");

        // 鼠标移动到“设置”按钮上并悬停
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.id("s-usersetting-top"))).perform();
        Thread.sleep(2000);


        //定位搜索设置并点击
        driver.findElement(By.linkText("搜索设置")).click();
        Thread.sleep(3000);

        //保存设置
        driver.findElement(By.xpath("//div[@id='se-setting-7']/a[2]")).click();
        Thread.sleep(3000);


        //接受弹框内容
        String text = driver.switchTo().alert().getText();
        System.out.println(text);

        //接受弹窗
        driver.switchTo().alert().accept();

        driver.quit();

    }



}

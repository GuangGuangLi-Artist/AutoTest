package com.course.muke.cases.casecollection;

import com.course.muke.cases.utils.ProUtil;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login {
    public WebDriver driver;
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin");
        driver.manage().window().setSize(new Dimension(1500,2000));


    }

    //获取定位元素的值
    public By getByByLocal(String key){
        ProUtil proUtil = new ProUtil("src/main/java/com/course/muke/cases/config/element.properties");
        String locator = proUtil.getPro(key);//name>email

        String locatorBy = locator.split(">")[0];//name
        String locatorValue = locator.split(">")[1];//email
        System.out.println(locatorValue);
        if(locatorBy.equals("id")){
         return By.id(locatorValue);
        }else if(locatorBy.equals("name")){
            return By.name(locatorValue);
        }else if(locatorBy.equals("className")){
            return By.className(locatorValue);
        }else {
            return By.xpath(locatorValue);
        }
    }

    //获取Element
    public WebElement getElement(String key){
        WebElement element = driver.findElement(this.getByByLocal(key));
        return element;
    }

    public void getScreenImg() throws FileNotFoundException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_ss");
        String curTime = dateFormat.format(new Date());

        //String clsName = this.getClass().getName();
        String pngName = curTime + ".png";

        String curPath = System.getProperty("user.dir");
        System.out.println(curPath);
        File logFile = ((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
        FileInputStream fis = new FileInputStream(logFile);
        try {
            Files.copyFile(fis,new File("src/main/java/com/course/muke/cases/log/" + pngName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void userLogin() throws FileNotFoundException {

        //加载user的配置信息
        ProUtil userProUtil = new ProUtil("src/main/java/com/course/muke/cases/config/user.properties");
        //获取user.properties的数据条数
        int userLines = userProUtil.properties.size();
        for (int i = 0; i <userLines ; i++) {
            initDriver();
            String userPro = userProUtil.getPro("user" + i);
            String userPro_name = userPro.split(">")[0];
            String userPro_password = userPro.split(">")[1];

            //WebElement loginbutton = getElement("login");
            WebElement emailElement = getElement("username");
            WebElement passWordElement = getElement("password");
            WebElement loginButtonElement = getElement("loginbutton");
            //loginbutton.click();
            //driver.switchTo().defaultContent();
            emailElement.sendKeys(userPro_name);
            passWordElement.sendKeys(userPro_password);
            loginButtonElement.click();
            getScreenImg();
            try {
                Thread.sleep(5000);
            }catch (Exception e){
                throw new RuntimeException(e);
            }

            try{
                //WebElement userPng = driver.findElement(By.id("header-avator"));
                WebElement userPng = getElement("headpng");
                Actions actions = new Actions(driver);
                actions.moveToElement(userPng).perform();
                String userNameInfo = getElement("userinfo").getText();
                if(userNameInfo.equals("慕标1365638")){
                    System.out.println("登录成功");
                }else {
                    System.out.println("用户信息不匹配");
                }

            }catch (Exception e){
                System.out.println("登录失败");
            }
            driver.close();
        }







    }


    /**
     * 发送邮箱
     */
    @Test
    public void sendToEmail(){


        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.163.com");
        //xxx的获取方式
        // 电脑Web端登录163邮箱：https://mail.163.com/。
        //进入“设置 > POP3/SMTP/IMAP”，确认对应服务已开启。若未开启，请勾选并保存
        email.setAuthentication("15607521232@163.com","xxxx");

        try {
            email.setFrom("15607521232@163.com");
            email.addTo("xxx@qq.com");
            email.setCharset("utf-8");
            email.setSubject("这是设置主题");
            email.setMsg("测试使用commons-email发送邮件");
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }


/*    public static void main(String[] args) {
        Login login = new Login();
        login.userLogin();

    }*/




}

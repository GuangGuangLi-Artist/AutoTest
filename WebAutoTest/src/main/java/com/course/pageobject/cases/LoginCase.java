package com.course.pageobject.cases;

import com.course.muke.cases.casecollection.TestNgListenerScreen;
import com.course.pageobject.handle.LoginHandle;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListenerScreen.class)
public class LoginCase {

    public WebDriver driver;
    public LoginHandle loginHandle;
    public static Logger logger =Logger.getLogger(LoginCase.class);

    @BeforeClass
    public void beforeLogin(){


        PropertyConfigurator.configure("src/main/java/com/course/muke/cases/config/log4j.properties");
        logger.debug("初始化浏览器");
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin");
        driver.manage().window().setSize(new Dimension(1500,2000));

        loginHandle = new LoginHandle(driver);
    }


    @AfterClass
    public void afterLogin(){
        driver.close();

    }

    @Test
    public void loginSuccess(){

        loginHandle.sendEmail("940102569@qq.com");
        loginHandle.sendPassword("");

        try {
            loginHandle.clickLgbtn();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String userName = loginHandle.getUsertext();
        Assert.assertEquals(userName,"慕标1365638");

    }
}

package com.course.pageobject.cases;

import com.course.muke.cases.casecollection.TestNgListenerScreen;
import com.course.pageobject.handle.LoginHandle;
import com.course.pageobject.utils.InitDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNgListenerScreen.class)
public class LoginCase  extends InitDriver{

    public WebDriver driver;
    public LoginHandle loginHandle;
    public static Logger logger =Logger.getLogger(LoginCase.class);

    @Parameters({"uri","browser"})
    @BeforeClass
    public void beforeLogin(String uri,String browser){


        PropertyConfigurator.configure("src/main/java/com/course/muke/cases/config/log4j.properties");
        //logger.debug("初始化浏览器");
        driver = getDriver(browser);
        driver.get(uri);
        driver.manage().window().setSize(new Dimension(1500,2000));

        loginHandle = new LoginHandle(driver);
        loginHandle.clickSignButton();
        try {
            loginHandle.clickSignButton();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterClass
    public void afterLogin(){
        driver.close();

    }

    @Parameters({"username","password"})
    @Test
    public void loginSuccess(String username,String password){

        loginHandle.sendEmail(username);
        loginHandle.sendPassword(password);

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

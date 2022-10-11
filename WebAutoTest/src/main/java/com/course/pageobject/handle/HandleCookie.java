package com.course.pageobject.handle;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.Set;

public class HandleCookie {
    WebDriver driver;
    @Test
    public void beforeClassCookie() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://coding.imooc.com/class/535.html?mc_marking=bb86c9071ed9b7cf12612a2a85203372&mc_channel=hk");
        driver.manage().window().setSize(new Dimension(1500,2000));




    }

    @Test
    public void getCookie(){
        String cookie = "";
        Boolean flag = isHaveCookie();
        if(!flag){
            driver.manage().deleteAllCookies();
            Cookie cookieGen = new Cookie("apsid",cookie,".imooc.com","/",null);
            driver.manage().addCookie(cookieGen);
            //刷新浏览器
            driver.navigate().refresh();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    @AfterClass
    public void afterClassCookie(){
        driver.close();
    }

    public boolean isHaveCookie(){
        Set<Cookie> cookieSet = driver.manage().getCookies();
        for (Cookie cookie1: cookieSet){
            if(cookie1.getName().equalsIgnoreCase("apsid")){
                String cookieValue = cookie1.getValue();
                System.out.println("用户已登录，存在Cookie Cookie " + cookieValue);
                return true;
            }

        }
        System.out.println("用户未登录，自动注入Cookie");
        return false;
    }
}

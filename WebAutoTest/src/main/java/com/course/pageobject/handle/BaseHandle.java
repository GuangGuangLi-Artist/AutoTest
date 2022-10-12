package com.course.pageobject.handle;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class BaseHandle {


    public void addCookie(WebDriver driver,String cookie){
        driver.manage().deleteAllCookies();
        org.openqa.selenium.Cookie cookieGen = new Cookie("apsid",cookie,".imooc.com","/",null);
        driver.manage().addCookie(cookieGen);
        //刷新浏览器
        driver.navigate().refresh();
    }
}

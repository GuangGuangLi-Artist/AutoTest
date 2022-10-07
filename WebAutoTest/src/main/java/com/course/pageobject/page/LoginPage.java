package com.course.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 当前页面发生的
 *    按照页面进行所有元素的封装
 *    按照页面对所有元素的操作进行封装
 *    按照页面对所有case进行封装

 */
public class LoginPage extends Basepage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    //获取邮箱
    public WebElement getEmailElement(){
        return getElement("username");
    }

    //获取密码
    public WebElement getPasswordElement(){
        return getElement("password");
    }

    //获取7天免密码登录
    public WebElement getSevenElement(){
        return getElement("senven");
    }
    //获取登录按钮
    public WebElement getLoginButton(){
        return getElement("loginbutton");
    }

    public WebElement getHeadpngElement(){
        return getElement("headpng");
    }

    public WebElement getUserinfoElement(){
        return getElement("userinfo");
    }


}

package com.course.pageobject.handle;

import com.course.pageobject.page.Basepage;
import com.course.pageobject.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginHandle {

    public LoginPage loginPage;

    public LoginHandle(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    public void sendEmail(String email){
        loginPage.getEmailElement().sendKeys(email);
    }

    public void sendPassword(String password){
        loginPage.getPasswordElement().sendKeys(password);
    }

    public void clickSeven(){
        loginPage.getSevenElement().click();
    }

    public void clickLgbtn(){
        loginPage.getLoginButton().click();
    }

    public String getUsertext(){
        loginPage.moveToElement(loginPage.getHeadpngElement());
        String userText = loginPage.getUserinfoElement().getText();
        return userText;
    }

    public void clickSignButton(){
        loginPage.getSignButton().click();
    }
}

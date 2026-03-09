package com.testNgExample.pages;

import com.testNgExample.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // 定位符
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginBtn = By.id("loginButton");
    private final By errorMsg = By.cssSelector(".error-message");

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginSuccessful() {
        // 假设登录成功后会出现欢迎语，或者错误信息消失
        // 这里为了演示，我们检查是否出现了错误信息
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
            return false; // 如果有错误信息，说明登录失败
        } catch (Exception e) {
            return true; // 没找到错误信息，假设成功
        }
    }
}

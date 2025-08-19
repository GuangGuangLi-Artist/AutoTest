package com.course.code.playwrightLearn;

import com.microsoft.playwright.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

public class AutoCases {

    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;




    @BeforeClass
    void initBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setArgs(Collections.singletonList("--start-maximized"))
                .setHeadless(false)
                .setChromiumSandbox(true)
                .setSlowMo(5000));

        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
        page = context.newPage();

    }


    @Test(description = "这是测试登录的网站")
    @Description("验证GET请求返回状态和内容")
    @Severity(SeverityLevel.CRITICAL)
    @Story("基础API测试")
    @Feature("API功能测试")
    public void testScript1() {
        page.navigate("https://www.baidu.com/");
        page.locator("//div[@id='chat-input-area']/textarea").fill("test");
        page.locator("#chat-submit-button").press("Enter");

    }


    @AfterClass
    public void closeBrowser() {
        browser.close();
        context.close();
        playwright.close();

    }
}

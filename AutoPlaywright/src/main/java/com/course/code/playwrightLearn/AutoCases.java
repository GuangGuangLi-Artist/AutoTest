package com.course.code.playwrightLearn;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoCases {


    @BeforeClass
    void initBrowser() {

    }


    @Test(description = "这是测试登录的网站")
    @Description("验证GET请求返回状态和内容")
    @Severity(SeverityLevel.CRITICAL)
    @Story("基础API测试")
    @Feature("API功能测试")
    public void testScript1() {
        String he = "hello";
        Assert.assertEquals(he, "hello");

    }


    @AfterClass
    public void closeBrowser() {

    }
}

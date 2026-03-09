package com.testNgExample.cases;

import com.testNgExample.driver.DriverFactory;
import com.testNgExample.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
    private static final Logger logger = LoggerFactory.getLogger(DataDrivenTest.class);

    @BeforeMethod
    public void setUp() {
        logger.info("BeforeMethod  执行BeforeMethod 加载 浏览器");
        DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        logger.info("AfterMethod  执行AfterMethod 关闭 浏览器");
        DriverFactory.quitDriver();
    }

    // 【核心知识点】数据提供者
    // 返回 Iterator<Object[]> 而不是 Object[][]，实现懒加载，避免大数据量 OOM
    @DataProvider(name = "loginData", parallel = true)
    public static Object[][] provideData() {
        logger.info("执行DataProvider 加载loginData 二维数组 ");
        return new Object[][]{
                {"user1", "pass123", true},   // 预期成功
                {"user2", "wrongPass", false},// 预期失败
                {"admin", "admin123", true},  // 预期成功
                {"test", "123", false}        // 预期失败
        };
    }

    /**
     * 【核心知识点】
     * 1. dataProvider: 绑定数据源
     * 2. retryAnalyzer: 绑定重试机制
     * 3. priority: 执行优先级
     */
    @Test(dataProvider = "loginData", retryAnalyzer = com.testNgExample.listeners.RetryAnalyzer.class, priority = 1)
    public void testLoginScenario(String username, String password, boolean expectSuccess) {
        LoginPage loginPage = new LoginPage();
        // 使用一个稳定的测试网站，这里用 Parabank 作为示例
        loginPage.navigateTo("https://parabank.parasoft.com/parabank/index.htm");

        // 注意：Parabank 的实际登录逻辑可能需要调整选择器，此处仅为逻辑演示
        // 为了演示效果，我们模拟一个简单的断言逻辑
        System.out.println(Thread.currentThread().getName() + " 正在测试: " + username);

        // 实际项目中应调用 loginPage.login(username, password);
        // 并进行断言：Assert.assertEquals(loginPage.isLoginSuccessful(), expectSuccess);

        // 模拟随机失败以触发重试机制 (演示用)
        if (username.equals("test") && Math.random() > 0.5) {
            logger.info("开始执行网络波动导致的失败的重试");
            throw new AssertionError("模拟网络波动导致的随机失败");
        }
    }
}

package com.testNgExample.cases;

import com.testNgExample.driver.DriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class WorkFlowTest {

    private static final Logger logger = LoggerFactory.getLogger(WorkFlowTest.class);

    @BeforeClass(alwaysRun = true)
    public void init() {
        logger.info("BeforeClass---加载浏览器");
        DriverFactory.initDriver();
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        logger.info("AfterClass---关闭浏览器");
        DriverFactory.quitDriver();
    }


    @Test(groups = {"smoke"}, priority = 1)
    public void openApplication() {
        logger.info("执行第一条测试用例 openApplication");
        if (DriverFactory.getDriver() == null) {
            DriverFactory.initDriver();
        }
        System.out.println("步骤 1: 打开应用首页");
        DriverFactory.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
        // 假设这里可能失败
        // throw new RuntimeException("首页打不开");
    }

    // 【核心知识点】依赖测试：只有 openApplication 成功，此方法才会执行
    // 如果 openApplication 失败，此方法会被标记为 SKIP
    @Test(dependsOnMethods = {"openApplication"}, groups = {"smoke", "regression"}, priority = 2)
    public void verifyTitle() {
        logger.info("执行第二条测试用例 verifyTitle");
        if (DriverFactory.getDriver() == null) {
            DriverFactory.initDriver();
        }
        String title = DriverFactory.getDriver().getTitle();
        System.out.println("步骤 2: 验证标题: " + title);
        //Assert.assertEquals(title,"ParaBank");
        Assert.assertTrue(title.contains("ParaBank"),"标题中未包含 ParaBank，实际标题为：" + title);
    }

    // 【核心知识点】alwaysRun = true
    // 即使依赖的方法失败了，或者前面的步骤失败了，这个方法也会强制执行
    // 常用于清理资源或记录最终状态
    @Test(dependsOnMethods = {"verifyTitle"}, alwaysRun = true, priority = 3)
    public void tearDownStep() {
        logger.info("执行第三条测试用例 tearDownStep");
        if (DriverFactory.getDriver() == null) {
            DriverFactory.initDriver();
        }
        System.out.println("步骤 3: 执行清理工作 (即使前面失败了也要执行)");
    }


}

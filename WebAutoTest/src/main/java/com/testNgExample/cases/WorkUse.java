package com.testNgExample.cases;

import com.testNgExample.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class WorkUse {

    private static Logger logger = LoggerFactory.getLogger(WorkUse.class);

    @BeforeClass
    public void beforeUse(){
        DriverFactory.initDriver();

    }

    @Test(priority = 0)
    public void testUsePriority(){
        System.out.println("Running on Thread: " + Thread.currentThread().getName() + " | ID: " + Thread.currentThread().getId());
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        String s = "priority = = 0";

        Assert.assertEquals(s,"priority = = 0");
        logger.info(s);
    }

    @Test(priority = 2,dependsOnMethods = "testUsePriority")
    public void testUsePriority2(){
        System.out.println("Running on Thread: " + Thread.currentThread().getName() + " | ID: " + Thread.currentThread().getId());
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        String s = "priority = = 2";
        Assert.assertEquals(s,"priority = = 0");
        logger.info(s);

    }

    @Test(priority = 1)
    public void testUsePriority1(){
        System.out.println("Running on Thread: " + Thread.currentThread().getName() + " | ID: " + Thread.currentThread().getId());
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        String s = "priority = = 1";
        Assert.assertEquals(s,"priority = = 1");

        logger.info(s);

    }

    @Test(priority = 3,dependsOnMethods = "testUsePriority2")
    public void testUsePriority3(){
        System.out.println("Running on Thread: " + Thread.currentThread().getName() + " | ID: " + Thread.currentThread().getId());
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        String s = "priority = = 3";
        Assert.assertEquals(s,"priority = = 3");

        logger.info(s);

    }

    @AfterClass
    public void afterUse(){
        DriverFactory.quitDriver();
    }
}

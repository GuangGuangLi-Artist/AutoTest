package com.course.code.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite 运行啦");
    }


    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite 运行啦");
    }

    @BeforeTest
    public void beforeTestCase1(){
        System.out.println("BeforeTest运行啦");
    }

    @AfterTest
    public void afterTestCase1(){
        System.out.println("AfterTest运行啦");
    }



}

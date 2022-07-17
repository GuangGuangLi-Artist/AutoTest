package com.course.code.testng;

import org.testng.annotations.*;

public class BasicAnnotation {



    @Test
    public void testCase1(){
        System.out.println("这是最基本的注解Test,用来把方法标记为测试的一部分");
    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod这是在测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod是在测试方法之后运行的");
    }

    @Test
    public void testCase2(){
        System.out.println("这是第二个测试方法testCase2");
    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass是在类运行之前运行的");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass是在类运行之后运行的");
    }


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件在beforeClass前");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件在afterClass后");
    }
}

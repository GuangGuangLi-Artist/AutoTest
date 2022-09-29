package com.course.muke.cases.casecollection;

import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNgListenerScreen.class)
public class TestNgUseTest {


    @Test
    public void test(){
        //Assert.assertEquals(1,2);
        System.out.println("method--测试使用方法");
    }

    @Test(groups = "group1")
    public void group1TestMethod(){
        System.out.println("groupTestMethod--测试使用方法");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass--测试使用方法");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass--测试使用方法");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod--测试使用方法");
    }


    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod--测试使用方法");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite--测试使用方法");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite--测试使用方法");
    }

    @BeforeGroups(groups = "group1")
    public void beforeGroups(){
        System.out.println("beforeGroups--group1TestMethod测试使用方法");
    }

    @AfterGroups(groups = "group1")
    public void afterGroups(){
        System.out.println("afterGroups--group1TestMethod测试使用方法");
    }







}

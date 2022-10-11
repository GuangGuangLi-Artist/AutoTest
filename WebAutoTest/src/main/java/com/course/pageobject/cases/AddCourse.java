package com.course.pageobject.cases;

import com.course.pageobject.handle.AddCourseHandle;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddCourse  extends InitDriver{
    /**
     * 添加课程测试
     * 测试两个场景
     *  1：没有登录 跳转到登录页面
     *  2：已登录 添加到购物车
     */

    WebDriver driver;

    @Parameters({"browser","uri"})
    @BeforeClass
    public void addCourseBeforeClass(String browser,String uri){
        driver = getDriver(browser);
        driver.get(uri);
        driver.manage().window().setSize(new Dimension(1500,2000));

    }


    @Test
    public void noCookieAddCourse(){
        //点击加入购物车
        AddCourseHandle courseHandle = new AddCourseHandle(driver);
        courseHandle.clickAddcart();
        String res = courseHandle.getActiveTitle();
        Assert.assertEquals(res,"账号登录");


    }

    @Test
    public void haveCookieAddCourse(){
        //点击加入购物车

    }





    @AfterClass
    public void addCourseAfterClasst(){
        driver.close();

    }

}

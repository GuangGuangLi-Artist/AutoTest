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
    @Parameters({"cookie"})
    @Test
    public void haveCookieAddCourse(String cookie) throws InterruptedException {
        //点击加入购物车
        AddCourseHandle courseHandle = new AddCourseHandle(driver);
        //添加用户登录Cookie
        courseHandle.addCookie(driver,cookie);
        courseHandle.clickAddcart();
        courseHandle.clickAddcart();
        Thread.sleep(5000);
        String content = courseHandle.getHaveCourse();

        Assert.assertEquals(content,"商品已经在购物车内");



    }





    @AfterClass
    public void addCourseAfterClasst(){
        driver.close();

    }

}

package com.testNgExample.cases;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameter {

    @Parameters({"browser","env"})
    @Test
    public void testParameter(String browserName ,String env){
        System.out.println("浏览器:" + browserName + " 环境：" + env);


    }

    //提供注解默认值
    @Parameters({"userName"})
    @Test
    public void testParameterOption(@Optional("zhangsan") String user){
        System.out.println("注解在TestNg.xml没有赋值,默认取optional === " + user);
    }
}

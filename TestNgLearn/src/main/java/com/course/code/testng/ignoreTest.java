package com.course.code.testng;

import org.testng.annotations.Test;

public class ignoreTest {

    @Test
    public void ignoreCase1(){
        System.out.println("ignoreTestCase1");
    }


    //忽略测试执行
    @Test(enabled = false)
    public void ignoreCase2(){
        System.out.println("ignoreTestCase2");
    }

    @Test(enabled = true)
    public void ignoreCase3(){
        System.out.println("ignoreTestCase3");
    }
}

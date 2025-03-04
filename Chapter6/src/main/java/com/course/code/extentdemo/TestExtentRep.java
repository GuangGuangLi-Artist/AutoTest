package com.course.code.extentdemo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class  TestExtentRep {

    @Test
    public void testFalse(){
        Assert.assertEquals(1,2);
    }


    @Test
    public void testTrue(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void testString(){
        Assert.assertEquals("aaa","aaa");
    }

    @Test
    public void testLog(){
        Reporter.log("这是我们自己写的日志");
        throw new RuntimeException("这是我们自己运行时的异常");
    }
}

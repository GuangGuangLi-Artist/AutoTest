package com.course.code.exception;

import org.testng.annotations.Test;

public class ExceptionTest {

    /**
     * 在期望结果为异常的时候会使用异常测试
     *
     * 预期结果就是一个异常
     */


    @Test(expectedExceptions = RuntimeException.class)
    public void testtuntimeExp(){

        int i = 10;
        int v = 0;
        int res = i/v;
        System.out.println("这是一个成功的异常测试");
        System.out.println(res);

    }
}

package com.testNgExample.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;

/**
 * expectedExceptions 期望抛出的异常类型。如果抛出指定异常，用例算PASS；否则算 FAIL。
 * expectedExceptionsMessageRegExp	期望异常信息的正则表达式。
 * threadPoolSize 为该特定方法创建独立的线程池大小
 * attributes 自定义键值对属性。
 */

public class TestAnnoException {

    private static Logger logger = LoggerFactory.getLogger(TestAnnoDataProvider.class);

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDataExpedExceptions() {

        logger.info("testDataExpedExceptions");
        System.out.println("ArithmeticException.class") ;
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
        int i= 1 / 0;


    }

    @Test(expectedExceptionsMessageRegExp = ".*Invalid password.*",
    expectedExceptions = IllegalArgumentException.class)
    public void testExpectedExceptionsMessageRegExp(){
        logger.info("testExpectedExceptionsMessageRegExp");
        System.out.println("testExpectedExceptionsMessageRegExp") ;
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
        throw new IllegalArgumentException("Invalid password for user: admin");

    }

    @Test(threadPoolSize = 3,// 使用 3 个线程并行执行
    invocationCount = 10,// 总共运行 10 次
    timeOut = 5000)// 所有 10 次执行的总超时时间
    public void testThreadPoolSize(){
        logger.info("testThreadPoolSize");
        System.out.println("testThreadPoolSize") ;
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }


    //MyReportListener test_Exception.xml
    @Test(attributes = {@CustomAttribute(name="Attribute",values={"name"}),@CustomAttribute(name = "priority_level", values = {"high"})})
    public  void testAttribute() {
        logger.info("testAttribute");
        System.out.println("testAttribute") ;
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }
}

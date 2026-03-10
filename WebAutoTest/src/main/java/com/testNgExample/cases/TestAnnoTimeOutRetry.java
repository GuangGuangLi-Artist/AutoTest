package com.testNgExample.cases;

import com.testNgExample.listeners.TestrRetryUse;
import org.aopalliance.intercept.Invocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAnnoTimeOutRetry {
    /**
     * 超时与重试机制：处理不稳定用例（Flaky Tests）和执行耗时控制。
     *     timeOut 总超时时间 (毫秒)。包含该方法所有调用的总耗时。超时即判失败
     *     invocationTimeOut 	单次调用超时时间 (毫秒)。配合 invocationCount 使用。
     *     invocationCount  指定该方法执行的次数
     *     successPercentage  	期望的成功率 (%)。配合 invocationCount 使用。
     *     retryAnalyzer 指定一个实现了 IRetryAnalyzer 接口的类，用于自定义重试逻辑。
     *     skipFailedInvocations 	在多次调用中，如果某次失败，是否跳过后续调用？
     */

    private static Logger logger = LoggerFactory.getLogger(TestAnnoTimeOutRetry.class);

    @Test(timeOut = 5000)
    public void testTimeOut() throws InterruptedException {
        logger.info("testTimeOut");
        Thread.sleep(3000);
        System.out.println("testTimeOut");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");

    }

    @Test(invocationTimeOut = 4000,invocationCount = 3) // sleep *count < invocationTimeOut 才能执行成功
    public void testinvocationTimeOut() throws InterruptedException {
        logger.info("testinvocationTimeOut");
        Thread.sleep(1000);
        System.out.println("testinvocationTimeOut");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");

    }

    @Test(successPercentage = 60,invocationCount = 10)//逻辑：运行 10 次，只要成功率达到 80%（即成功 8 次及以上），TestNG 就认为该测试 Pass
    public void testSuccessPercentage(){
        logger.info("testSuccessPercentage");
        double chance = Math.random();
        if(chance < 0.2) {
            throw new RuntimeException("网络波动，偶尔失败");
        }
        System.out.println("testSuccessPercentage");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");

    }

    @Test(retryAnalyzer = TestrRetryUse.class)
    public void testRetryAnalyzer(){
        logger.info("testRetryAnalyzer");
        double chance = Math.random();
        if(chance < 0.7) {
            Assert.assertTrue(false,"执行失败，需要重试");
        }
        System.out.println("testRetryAnalyzer");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }


    //用于验证监听器配置重试机制，对应xml文件为timeoutRetry.xml
    @Test(groups = {"retryxmlUse"})
    public void testRetryAnalyzerWithXML(){
        logger.info("testRetryAnalyzerWithXML");
        double chance = Math.random();
        if(chance < 0.7) {
            Assert.assertTrue(false,"执行失败，需要重试");
        }
        System.out.println("testRetryAnalyzerWithXML");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }


    //在多次调用中，如果某次失败，是否跳过后续调用？
    @Test(skipFailedInvocations = true,invocationCount = 10)
    public void testSkipFailedInvocations(){
        logger.info("testSkipFailedInvocations");
        double chance = Math.random();
        if(chance < 0.5) {
            Assert.assertTrue(false,"执行失败");
        }
        System.out.println("testSkipFailedInvocations");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");

    }








}

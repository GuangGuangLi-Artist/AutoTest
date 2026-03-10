package com.testNgExample.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 *  singleThreaded 如果为 true，该 <test> 标签下的所有方法将在同一个线程中串行执行，即使 suite 设置了并行。
 *  singleThreaded 要加在class上的@Test上，不能加在method上
 */

@Test(singleThreaded = true)
public class TestAnnoSingleThreaded {

    private static Logger logger = LoggerFactory.getLogger(TestAnnoDataProvider.class);

    //test_singleThreaded.xml


    public void step1_Login() {
        logger.info("step1_Login");
        System.out.println("Step 1: 线程ID - " + Thread.currentThread().getId());
    }

    public void step2_Order() {
        logger.info("step2_Order");
        System.out.println("Step 2: 线程ID - " + Thread.currentThread().getId());
    }

}

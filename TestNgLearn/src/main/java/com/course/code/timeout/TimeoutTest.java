package com.course.code.timeout;

import org.testng.annotations.Test;

public class TimeoutTest {


    @Test(timeOut = 300)//单位为毫秒
    public void testSuccess() throws InterruptedException {
        Thread.sleep(200);

    }

    @Test(timeOut = 300)//单位为毫秒
    public void testFailed() throws InterruptedException {
        Thread.sleep(400);

    }
}

package com.testNgExample.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {


    private int count = 0;
    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < maxRetryCount) {
            count++;
            System.out.println(">>> 测试失败，正在进行第 " + count + " 次重试...");
            return true;
        }
        return false;
    }
}

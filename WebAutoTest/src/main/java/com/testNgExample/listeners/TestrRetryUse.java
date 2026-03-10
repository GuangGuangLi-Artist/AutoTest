package com.testNgExample.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestrRetryUse implements IRetryAnalyzer {
    private  int count = 0;
    private static final int MAX_RETRY_COUNT = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if(count < MAX_RETRY_COUNT){
            count++;
            System.out.println("【重试机制】正在重试测试用例: " + iTestResult.getName() + "，当前重试第 " + count + " 次");
            return true; // 返回 true 表示继续重试

        }
        return false;// 返回 false 表示停止重试

    }
}

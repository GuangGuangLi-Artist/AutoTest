package com.course.muke.cases.casecollection;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestNgListenerScreen extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("case执行失败");
        super.onTestFailure(iTestResult);
    }
}

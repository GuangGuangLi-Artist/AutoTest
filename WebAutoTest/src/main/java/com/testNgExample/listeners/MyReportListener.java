package com.testNgExample.listeners;

import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.CustomAttribute;

public class MyReportListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestNGMethod method = result.getMethod();
        CustomAttribute[] customAttributes = method.getAttributes();
        for (CustomAttribute customAttribute:customAttributes) {
            if (("priority_level".equals(customAttribute.name())))
            {
                String level = customAttribute.values()[0];
                System.out.println("检测到用例优先级: " + level);
                // 根据优先级做特殊处理，比如发送告警邮件
            }
        }
    }
}

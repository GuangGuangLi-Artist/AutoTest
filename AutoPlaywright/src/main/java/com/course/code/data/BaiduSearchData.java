package com.course.code.data;

import org.testng.annotations.DataProvider;

public class BaiduSearchData {

    @DataProvider(name = "searchKeywords")
    public static Object[][] provideKeywords() {
        return new Object[][] {
                {"Playwright Java"},
                {"TestNG 教程"},
                {"自动化测试"},
                {"ChatGPT"},
                {"AI 搜索引擎"}
        };

    }
}

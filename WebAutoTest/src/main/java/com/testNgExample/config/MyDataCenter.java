package com.testNgExample.config;

import org.testng.annotations.DataProvider;

public class MyDataCenter {

    @DataProvider(name="loginData")
    public static Object[][] getLogData(){
       return new Object[][]{
               {"admin","123"},
               {"testUser","111"}
       };
    }

    @DataProvider(name="searchData")
    public static Object[][] getSearchData(){
        return new Object[][]{
                {"selenium"},
                {"TestNg"},
                {"java"}
        };
    }


    @DataProvider(name = "dynamicData")
    public static Object[][] provideData(java.lang.reflect.Method method) {
        String methodName = method.getName();
        if (methodName.equals("testA")) {
            return new Object[][] { {"Data for A"} };
        } else {
            return new Object[][] { {"Data for Others"} };
        }
    }
}

package com.testNgExample.cases;

import com.testNgExample.config.MyDataCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestAnnoDataProviderCls {

    private static Logger logger = LoggerFactory.getLogger(TestAnnoDataProviderCls.class);

    @Test(dataProvider = "loginData",dataProviderClass = MyDataCenter.class)
    public void testUseDataProviderClass(String userName,String password){
        logger.info("testUseDataProviderClass");
        System.out.println("姓名:" + userName + "密码:" + password) ;
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }



    //动态调用
    @Test(dataProvider = "dynamicData",dataProviderClass = MyDataCenter.class)
    public void testA(String data){
        logger.info("testUseDataProviderClass");
        System.out.println("data:" + data) ;
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }

    @Test(dataProvider = "dynamicData",dataProviderClass = MyDataCenter.class)
    public void testB(String data){
        logger.info("testUseDataProviderClass");
        System.out.println("data:" + data) ;
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }
}

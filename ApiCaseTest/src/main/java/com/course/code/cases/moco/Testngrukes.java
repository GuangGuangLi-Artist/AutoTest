package com.course.code.cases.moco;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.SetCookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testngrukes {

    private CookieStore cookieStore;
    //beforeClass的值要在后续的test中使用
    private String classValue;


    @BeforeClass
    public void beforeCl(){
        cookieStore = new BasicCookieStore();
        Cookie cookie = new BasicClientCookie("login","true");
        cookieStore.addCookie(cookie);

        classValue = "这是类方法之前就已经赋值的东西，在test中就可以直接使用";
        System.out.println("beforeclass----------给classVlue进行赋值");

    }


    @Test
    public void testCookie(){

        System.out.println("test----------" + classValue);
    }

    @AfterClass
    public void afterCl(){
        classValue = "";
        System.out.println("afterclass----------清空了classValue" + classValue);

    }
}

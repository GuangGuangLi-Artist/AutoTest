package com.course.code.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {


    @Test(groups = "server")
    public void serverTest1(){
        System.out.println("这是服务端的测试方法1");
    }

    @Test(groups = "server")
    public void serverTest2(){
        System.out.println("这是服务端的测试方法2");
    }
    @Test(groups = "client")
    public void clientTest1(){
        System.out.println("这是客户端的测试方法1");
    }

    @Test(groups = "client")
    public void clientTest2(){
        System.out.println("这是客户端的测试方法2");
    }

    @BeforeGroups(groups = "server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组运行之前运行的方法");
    }

    @BeforeGroups(groups = "client")
    public void beforeGroupsOnClient(){
        System.out.println("这是客户端组运行之前运行的方法");
    }


    @AfterGroups(groups = "server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组运行之后运行的方法");
    }

    @AfterGroups(groups = "client")
    public void afterGroupsOnClient(){
        System.out.println("这是客户端组运行之后运行的方法");
    }
}

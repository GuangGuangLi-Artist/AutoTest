package com.course.code.commonFunction;

import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CommonFunction {

    //java 常用类的方法复习

    @Test
    public void testSystem() {
        //获取系统当前时间（毫秒）（距离1970年1月1日00:00:00
        System.out.println(System.currentTimeMillis());

        System.getProperties().list(System.out);
        //usr.dir 是什么 参考 https://blog.csdn.net/qq_43842093/article/details/130175513
        //获取用户当前工作目录
        System.out.println(System.getProperty("user.dir"));

    }

    @Test
    public void testString() {

        String s = "  liguangTestString  ";
        //String转数组� �byte[]�getBytes()�
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        for (byte b : bytes) {
            System.out.println(b);
        }

        System.out.println("---------------");
        int length = s.length();
        System.out.println(length);
        System.out.println("---------------");
        boolean equals = s.equals("liguangTestString1");
        System.out.println(equals);

        System.out.println("---------------");
        System.out.println("charAt: " +s.charAt(1));
        System.out.println("indexOf: " +s.indexOf("li"));
        System.out.println("lastIndexOf: " + s.lastIndexOf("li"));
        System.out.println("isEmpty: " + s.isEmpty());
        System.out.println("contentEquals: " + s.contentEquals("ls"));
        System.out.println("toUpperCase: " + s.toUpperCase());
        System.out.println("toLowerCase: " + s.toLowerCase());
        System.out.println("startsWith: " + s.startsWith("s"));
        System.out.println("endsWith: " + s.endsWith("s"));
        System.out.println("substring: " + s.substring(1, s.length() - 1));
        System.out.println("replace: " + s.replace('l','s'));
        System.out.println("trim: " + s.trim());

        System.out.println("---------------");
        char[] chars = {'a','c'};
        System.out.println("valueOf: " + String.valueOf(chars));
        System.out.println("format: " + String.format("Hi,%s",s));
        List<String> sli = new ArrayList<>();
        sli.add("hehe");
        sli.add("wawa");
        System.out.println("join: " + String.join("--",sli));


    }
}

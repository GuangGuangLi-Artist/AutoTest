package com.course.code.generic;

import org.testng.annotations.Test;

public class GenericTest {


    @Test
    public void runStr(){
        GenericDemoImpl<String> genericDemo = new GenericDemoImpl<String>();
        genericDemo.printTonConsle("泛型文字符串");
        String a = genericDemo.returnStr("返回的字符串");
        System.out.println(a);

    }

    @Test
    public void runInt(){
        GenericDemoImpl<Integer> genericDemo = new GenericDemoImpl<Integer>();
        genericDemo.printTonConsle(100);
        Integer a = genericDemo.returnStr(1000);
        System.out.println(a);
    }



}

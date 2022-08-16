package com.course.code.coreclass;

import org.testng.annotations.Test;

public class StringTest {


    @Test
    public void stringMethod(){
        String s1 = "hello";
        String s2 = "world";
        String s3 = s1.toUpperCase();
        System.out.println(s1);
        System.out.println(s3);

    }

   @Test
    public void splitString(){
        String s1 ="A,B,C,D";
        String[] splits1 = s1.split(",");
       for (String s:splits1){
           System.out.print(s);
       }
    }

    @Test
    public void joinString(){
        String[] s1 = {"A","B","C"};
        String s3 = String.join("***",s1);
        System.out.println(s3);
    }

    @Test
    public void stringBuilderTest(){

        StringBuilder stringBuilder = new StringBuilder(1024);
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append(',');
            stringBuilder.append(i);
        }
        String s = stringBuilder.toString();
        System.out.println(s);
    }



}

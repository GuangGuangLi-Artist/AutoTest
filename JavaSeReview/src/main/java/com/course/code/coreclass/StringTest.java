package com.course.code.coreclass;

import org.testng.Assert;
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


    //2:任何数据和字符串进行操作，结果都是字符串类型。
    // 但是要注意运算的顺序。
    @Test
    public void  stringOut(){
        System.out.println('a');//a
        System.out.println('a' + 1);//98
        System.out.println('a' + 1 + "hello");//98hello
        System.out.println("hello"+ 'a' + 1);//helloa1
        System.out.println("5 + 5 = " + 5 + 5);//5 + 5 = 55
        System.out.println( 5 + 5 + "=5 + 5");//10=5 + 5


    }


    @Test
    public void plusAndredece(){
        int a = 2;
        int b = ++a;
        System.out.println("a = " + a );//3
        System.out.println("b = " + b );//3

        int c = 2;
        int d = c++;
        System.out.println("c = " + c);//3
        System.out.println("d = " + d);//2


        int e = 2;
        int f = --e;
        System.out.println("e = " + e);//1
        System.out.println("f = " + f);//1

        int x = 2;
        int y = x--;
        System.out.println("x = " + x);//1
        System.out.println("y = " + y);//2


        //++a increments and then uses the variable.
        //a++ uses and then increments the variable.
        int h = 20;
        System.out.println(h++);

        int i = 20;
        System.out.println(++i);

        int m = 20;
        m+=1;
        System.out.println(m);//



    }

    @Test
    public void testFor(){

        int a = 1;
        int b = 1;
        for(int i=0;i<=10;i++){
            System.out.println(a+"\t"+b+"\t");
            a=a+b;
            b=a+b;
        }
        String[] stringArr = {"苏彪","赫赫拉拉","张彪","陈彪"};

        for (int i = 0; i < stringArr.length; ++i) {
            //System.out.println(stringArr[i]);
        }
    }

    @Test
    public void stringLearn(){
        String str1 = new String("baba");
        System.out.println(str1.toUpperCase());
        Assert.assertEquals(str1.toUpperCase(),"BABA");

    }





}
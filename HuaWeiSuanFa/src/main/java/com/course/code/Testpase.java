package com.course.code;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Testpase {
    @Test
    public void testPase(){
        Scanner s = new Scanner(System.in);
        int anInt = s.nextInt();
        String ss = String.valueOf(anInt);
        StringBuffer sb = new StringBuffer(ss);
        System.out.println(sb.reverse());


    }
}

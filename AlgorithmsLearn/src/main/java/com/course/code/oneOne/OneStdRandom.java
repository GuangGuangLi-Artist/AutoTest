package com.course.code.oneOne;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class OneStdRandom {

    public static void main(String[] args) {
        System.out.println("随机返回double的方法:" + StdRandom.uniform(1.00,100.00));
        System.out.println("随机返回int的方法:" + StdRandom.uniform(1,100));
        int[] aa = {12,25,76,55,67};
        System.out.println("根据离散概率随机返回int的方法:" + StdRandom.discrete(aa));
        StdOut.print("按照字符串打印数组:" + Arrays.toString(aa));
        StdOut.println("按照字符串打印数组:" + Arrays.toString(aa));
        StdOut.println();//打印一个换行符
        StdOut.printf("%12d\n",512);//格式化输出         512;
        StdOut.printf("%-12d\n",512);//格式化输出512         ;
        StdOut.printf("%14.2f\n",1595.1680010754388);//       1595.17
        StdOut.printf("%.7f\n",1595.1680010754388);//1595.1680011
        StdOut.printf("%14.4e\n",1595.1680010754388);//    1.5952e+03
        StdOut.printf("%14s\n","Hello, World");//  Hello, World
        StdOut.printf("%-14s\n","Hello, World");//Hello, World
        StdOut.printf("%-14.5s\n","Hello, World");//Hello
//        int[] ints = StdIn.readAllInts();
//        StdOut.println("你输入的整数数组为：" + Arrays.toString(ints));//使用ctrl + d结束
//        for (int i = 0; i < ints.length; i++) {
//            StdOut.println("你输入的整数分别为：" + ints[i]);
//        }

        int[] intsInRead = In.readInts();
        StdOut.println("你输入的整数数组为：" + Arrays.toString(intsInRead));



    }
}

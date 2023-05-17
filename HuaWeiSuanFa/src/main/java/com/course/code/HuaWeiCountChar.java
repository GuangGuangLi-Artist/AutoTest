package com.course.code;

import java.util.Locale;
import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 数据范围： 1<= n <= 1000
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * 示例1
 * 输入：
 * ABCabc
 * A
 * 输出：
 * 2
 */

public class     HuaWeiCountChar {

    public static void main(String[] args) {


        /**
         * 解题思路
         * 首先获取两次输入的字符串内容
         *
         * 将第一个字符串中的内容中如果存在第二个字符串中的内容，就使用“”替代 并记录这个字符串
         *
         * 使用第一个字符串减去第三个字符串的长度 留下的就是存在 字母出现的次数
         *
         * 这个题目的妙处就在于将计算字符的问题转化为长度的计算
         */

        Scanner scanner = new Scanner(System.in);
        String stringLine = scanner.nextLine();//ABCabc
        String secStr = scanner.nextLine();//A
        String split3 = stringLine.toUpperCase().replaceAll(secStr.toUpperCase(),"");  //ABCABC BCBC
        System.out.println(split3);
        System.out.println(stringLine.length()  -  split3.length());



    }

}

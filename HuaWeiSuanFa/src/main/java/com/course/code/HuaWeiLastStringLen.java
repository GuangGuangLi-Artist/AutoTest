package com.course.code;

import java.util.Scanner;

/**
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 */
public class HuaWeiLastStringLen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        //分割字符串

        String [] stringsArr =  str.split(" ");

        int x = stringsArr.length;//获取字符串数组长度

        //取出最后一个字符串
        String last = stringsArr[x-1];

        int lastlen = last.length();
        System.out.println(str + " 的最后一个字符串的长度为" + lastlen);

    }
}

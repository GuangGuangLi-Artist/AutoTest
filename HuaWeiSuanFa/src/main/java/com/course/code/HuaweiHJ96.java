package com.course.code;

import java.util.Scanner;

/**
 * 描述
 * 将一个字符串中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数
 *
 *
 *输入一个字符串
 *
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 *
 * 输入：Jkdi234klowe90a3
 * 输出：Jkdi*234*klowe*90*a*3*
 */

public class HuaweiHJ96 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ss = scanner.nextLine();

        char[] chs = ss.toCharArray();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chs.length; i++) {
            if(Character.isDigit(chs[i])){
               sb.append("*" + chs[i] + "*");
            }else {
                sb.append(chs[i]);
            }

        }

        String newS = sb.toString().replace("**","");
        System.out.println(newS);
    }
}

package com.course.code;

import java.util.Scanner;

/**
 *  最长回文子串
 * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
 * 所谓回文串，指左右对称的字符串。
 * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
 *
 * 输入一个仅包含小写字母的字符串
 *
 * 返回最长回文子串的长度
 */

public class HuaweiHJ85 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String resource = scanner.nextLine();

        int max = 0;
        for (int i = 0; i < resource.length(); i++) {
            for (int j = resource.length(); j > i; j--) {
                String toBeJudged = resource.substring(i,j);
                if(huiWen(toBeJudged)){
                    max = Math.max(max,j - i);
                }
            }
        }

        System.out.println(max);



    }


    //判断一个字符串是否是回文字符串
    public  static  boolean huiWen(String line){

        return line.equals(new StringBuffer(line).reverse().toString());
    }
}

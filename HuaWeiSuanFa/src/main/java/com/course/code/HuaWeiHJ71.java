package com.course.code;

import java.util.Locale;
import java.util.Scanner;

/**
 * 字符串通配符
 *
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 * ？：匹配1个字符
 *
 * 注意：匹配时不区分大小写。
 *
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * 输出：
 *
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 */
public class HuaWeiHJ71 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String wildcard = in.nextLine().toLowerCase(Locale.ROOT);
        String str = in.nextLine().toLowerCase(Locale.ROOT);

        // 缩减*号
        wildcard = shortAsterisk(wildcard);

        //输出
        System.out.println(isMatch(wildcard,str,0,0));
    }

    private static boolean isMatch(String wildcard, String str, int wildcardP, int strP) {

        //两个字符串同时结束，返回true;
        if(wildcard.length() == wildcardP && str.length() == strP){
            return true;
        }else if (wildcard.length() == wildcardP || str.length() == strP){
            // 两个字符串中有一个先结束，返回false
            return false;
        }

        if(wildcard.length() != wildcardP && (str.length() == strP)){
            //wildcardArray里全是* 匹配结果为 True
            //wildcardArray里不全是* 匹配结果为 False
            for (int i = 0; i < wildcard.length(); i++) {
                if(wildcard.charAt(i) != '*'){
                    return false;
                }
            }
            return true;

        }
        char currentWilcard = wildcard.charAt(wildcardP);
        char currentStr = str.charAt(strP);

        // 匹配的字符仅由英文字母和数字0到9组成
        if(currentWilcard != currentStr && !(Character.isDigit(currentStr) || Character.isLetter(currentStr))){
            return false;
        }else if (currentWilcard != currentStr && (Character.isDigit(currentStr) || Character.isLetter(currentStr))){
            if(currentWilcard == '?'){
                // 跳过，直接看下一位
                isMatch(wildcard,str,wildcardP + 1,strP + 1);
            }else if(currentWilcard == '*'){
                // 有三种选择：
                // 1、匹配0个，通配符向后移动一个字符，字符串不动；
                // 2、匹配1个，通配符和字符串都向后移动一个字符；
                // 3、匹配多个，通配符不动，字符串向后移动一个字符。

                return isMatch(wildcard,str,wildcardP + 1,strP) || isMatch(wildcard,str,wildcardP + 1,strP + 1)
                        || isMatch(wildcard,str,wildcardP,strP + 1);
            }else {
                return false;
            }
        }
        return isMatch(wildcard,str,wildcardP + 1,strP + 1);
    }

    private static String shortAsterisk(String str) {

        char[] arr = str.toCharArray();
        int len = arr.length;

        // 只有1个元素直接返回了
        if(len <= 1){
            return str;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            //如果前面的也是*，说明有连续*，丢掉本次的*
            if(arr[1] == '*' && arr[i-1] == '*'){
                // 什么都不做
            }else {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }


}

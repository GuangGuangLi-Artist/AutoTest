package com.course.code;

import java.util.Scanner;

/**
 *
 * 查找两个字符串a,b中的最长公共子串。
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开
 *
 * 输入两个字符串
 *
 * 返回重复出现的字符
 */
public class HuaWeiHJ65 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        // a作为较短的那个字符串
        String a;
        String b;

        if(s1.length() <= s2.length()){
            a = s1;
            b = s2;
        }else {
            a = s2;
            b = s1;
        }

        //看a 截取子串在b中是否包含
        int aLength = a.length();
        int aSubLength = aLength;
        String result = "";
        boolean isContinue  = true;
        while (aSubLength > 0 && isContinue){
            //从前往后截取
            for (int i = 0; i < aLength -aSubLength + 1; i++) {
                String aSub = a.substring(i, i + aSubLength);

                //如果包含 则程序结束
                if(b.contains(aSub)){
                    result = aSub;
                    isContinue = false;
                    break;
                }
            }

            //缩小截取范围
            aSubLength--;
        }

        System.out.println(result);
        scanner.close();

    }
}

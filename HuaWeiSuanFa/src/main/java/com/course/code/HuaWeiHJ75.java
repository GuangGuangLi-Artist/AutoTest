package com.course.code;


import java.util.Scanner;

/**
 *
 * 公共子串计算
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 *
 * 输入两个只包含小写字母的字符串
 * 输出一个整数，代表最大公共子串的长度
 *
 */
public class HuaWeiHJ75 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        // a作为较短的那个字符串

        String a;
        String b;

        if(s1.length() < s2.length()){
            a = s1;
            b = s2;
        }else {
            a = s2;
            b = s1;
        }

        // 看a截取子串在b中是否包含
        int aLength = a.length();
        int aSubLength = aLength;
        String  result  = "";
        boolean isContinue = true;
        while (aSubLength > 0 && isContinue){
            // 从前往后截取
            for (int i = 0; i < aLength - aSubLength + 1; i++) {
                String aSub = a.substring(i, i + aSubLength);

                // 如果包含，则程序结束
                if(b.contains(aSub)){
                    result = aSub;
                    isContinue = false;
                    break;
                }
            }

            // 缩小截取的范围
            aSubLength--;
        }

        System.out.println(result.length());

        scanner.close();

    }
}

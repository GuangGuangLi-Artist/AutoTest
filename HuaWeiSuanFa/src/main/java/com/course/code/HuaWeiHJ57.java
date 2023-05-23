package com.course.code;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * 高精度整数加法
 *
 * 输入两个用字符串 str 表示的整数，求它们所表示的数之和。
 * 输入两个字符串。保证字符串只含有'0'~'9'字符
 * 输出求和后的结果
 */
public class HuaWeiHJ57 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        // 输出
        System.out.println(add(str1, str2));

        // 关闭
        in.close();

    }

    public static String add(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int len = Math.max(len1,len2);

        StringBuilder sb = new StringBuilder();

        // 进位
        int carry = 0;

        // 从0算到len为止。
        for (int i = 0; i < len; i++) {
            int a1 = 0;
            int a2 = 0;

            // 逆序从低位开始取数
            if (len1 > i) {
                a1 = new StringBuilder(str1).reverse().toString().charAt(i) - '0';
            }
            if (len2 > i) {
                a2 = new StringBuilder(str2).reverse().toString().charAt(i) - '0';
            }

            // 本位数之和再加上进位的数
            int sum = a1 + a2 + carry;

            // 产生新的进位给下个循环用
            carry = sum/10;

            // 个位
            int onesPlace = sum%10;

            sb.append(onesPlace);
        }

        // 遍历完了，如果还有进位
        if (carry>0) {
            sb.append(carry);
        }

        // 逆序输出
        return sb.reverse().toString();

    }
}

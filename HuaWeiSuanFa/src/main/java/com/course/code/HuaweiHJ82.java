package com.course.code;


import java.util.Scanner;

/**
 * 将真分数分解为埃及分数
 *
 * 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。
 * 注：真分数指分子小于分母的分数，分子和分母有可能gcd不为1！
 * 如有多个解，请输出任意一个。
 *
 * 输入 输入一个真分数，String型
 * 输出 输出分解后的string
 */
public class HuaweiHJ82 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] ss = sc.nextLine().split("/");
            long a = Integer.parseInt(ss[0]);
            long b = Integer.parseInt(ss[1]);
            long t;
            StringBuilder sb = new StringBuilder();
            while (a != 0) {
                t = b / a + (b % a == 0 ? 0 : 1);
                if (b % t == 0 && a >= t) {
                    a -= b / t;
                    sb.append('1').append('/').append(t)
                            .append('+');
                } else {
                    a = a * t - b;
                    b = b * t; // 这里可能溢出，所以都用long
                    if (a != 0)
                        sb.append('1').append('/').append(t)
                                .append('+');
                    else
                        sb.append('1').append('/')
                                .append(t);
                }
                if (a == 1) {
                    sb.append('1').append('/').append(b);
                    break;
                }
            }
            System.out.println(sb);
        }

        sc.close();

    }
}

package com.course.code;

import java.util.Scanner;


/**
 * 等差数列 2，5，8，11，14。。。。
 * （从 2 开始的 3 为公差的等差数列）
 * 输出求等差数列前n项和
 *
 * 输入一个正整数n。
 *
 * 输出一个相加后的整数。
 *
 * Sn=nA1+n(n-1)d/2
 */
public class HuaweiHJ100 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int x = scanner.nextInt();
            int d = 3;
            int first = 2;
            int res = (int)x * first + (x*(x-1)*d)/2;
            System.out.println(res);
        }
        scanner.close();
    }
}

package com.course.code;

import java.util.Scanner;

/**
 *
 * 最小公倍数
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 输入两个正整数A和B。
 * 输出A和B的最小公倍数。
 */

public class HuaweiHJ108 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
         int a = sc.nextInt();
         int b = sc.nextInt();

        for (int i = 1; ; i++) {
            if(a*i%b==0){
                System.out.println(a*i);
                break;
            }
        }

    }
}

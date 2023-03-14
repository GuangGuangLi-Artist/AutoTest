package com.course.code;

import java.util.Scanner;

/**
 *自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n(包括n)以内的自守数的个数
 *
 *
 * int型整数
 * n以内自守数的数量。
 */

public class HuaweiHJ99 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int x = scanner.nextInt();
            int num = 0;
            for (int i = 0; i <= x; i++) {
                String sqr = String.valueOf(i * i);
                String si = String.valueOf(i);
                if(sqr.endsWith(si)){
                    num++;
                }
            }
            System.out.println(num);
        }
    }
}

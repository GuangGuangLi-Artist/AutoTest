package com.course.code;

import java.util.Scanner;

/**
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 *
 * 数据范围：输入的数据满足
 *
 * 输入一个大于2的偶数
 * 从小到大输出两个素数
 * 输入：20
 *
 * 输出：7
 *      13
 *
 *
 *质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数。
 *
 * 要求两个数插值最小，自然是两个数大小最接近。因此，先对偶数n折半作为遍历的起点，分为 n/2 和 n-n/2 两个数。
 * 判断这两个数 n/2+1 和 n/2-1 是否是素数。如果是，那么计算就结束，输出这两个数即可；如果不是，这两个数分别加1和减1，再次判断是否是素数，因此类推。
 * */

public class HuaweiHJ60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //折半
        int n1 = n / 2;
        int n2 = n - n1;

        while ( 0 < n1 && n2 < n){
            if(isPrime(n1) && isPrime(n2)){
                System.out.println(n1);
                System.out.println(n2);
                break;
            }
            n1 -= 1;
            n2 += 1;
        }

        sc.close();







    }

    public static boolean isPrime(int n){
        if(n <= 1){
            return false;
        }else {

            // 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数
            // 0和1既不是质数也不是合数，最小的质数是2

            for (int i = 2; i < n; i++) {
                if(n % i == 0){
                    return false;
                }
            }
        }
        return true;

    }

}

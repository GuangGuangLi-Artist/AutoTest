package com.course.code;

import java.util.Scanner;

/**
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 *
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 *
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 *
 * 输入n，请输出n以内(含n)完全数的个数。
 *
 * 解法
 * 如何求真因子？
 *
 * 约数，又称因数。整数a除以整数b(b≠0) 除得的商正好是整数而没有余数，我们就说a能被b整除，或b能整除a。a称为b的倍数，b称为a的约数。
 *
 * 真因子就是把自身排除在外的约数。
 *
 * 例如：28，要求它的真因子，就从尝试除以一个数（这个数从1开始遍历到27），如果没有余数，那这个数就是28的真因子。把这些真因子累加，如果等于28，则这个28是完全数。
 */

public class HuaweiHJ56 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countZhenYinZi(n));

        sc.close();
    }

    public static int countZhenYinZi(int n){
        int count = 0;
        for (int i = 1; i <= n; i++) {

            int sum = 0;
            for (int j = 1; j < i; j++) {
                if(i % j == 0){
                    sum += j;
                }
            }

            if(i == sum){
                count++;
            }
        }
        return count;
    }

}

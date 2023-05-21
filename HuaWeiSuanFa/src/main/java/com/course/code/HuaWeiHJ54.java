package com.course.code;


import java.util.Scanner;

/**
 * 挑7
 * 输出 1到n之间 的与 7 有关数字的个数。
 * 一个数与7有关是指这个数是 7 的倍数，或者是包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）
 *
 * 输入：一个正整数 n 。( n 不大于 30000 )
 * 输出：一个整数，表示1到n之间的与7有关的数字个数。
 */
public class HuaWeiHJ54 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //输出
        System.out.println(pickSeven(n));

        scanner.close();

    }

    private static int pickSeven(int n) {
        int count = 0;
        //从7算到n
        for (int i = 7; i <= n; i++) {
            if(i % 7 == 0){
                count++;
                continue;
            }
            if((i + "").contains("7")){
                count++;
                continue;
            }
        }
        return count;

    }
}

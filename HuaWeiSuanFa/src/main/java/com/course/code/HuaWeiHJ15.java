package com.course.code;

import java.util.Scanner;

/**
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 *
 *
 *  输入：5
 *  输出：2
 */

public class HuaWeiHJ15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String stringx = Integer.toBinaryString(x);
        char[] chars = stringx.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if('1'== chars[i]){
                count+=1;
            }


        }
        System.out.println(count);
    }
}

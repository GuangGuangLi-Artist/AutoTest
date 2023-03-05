package com.course.code;

import java.util.Scanner;

/**
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 * 计算整数二进制中1的个数
 *
 * 输入：5
 * 输出：2
 * 说明：5的二进制表示是101，有2个1
 */

public class HuaweiHJ62 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int a = in.nextInt();
            String strA = Integer.toBinaryString(a);

            char[] chs = strA.toCharArray();
            int num = 0;
            for (char ch:chs){
                if(ch == '1'){
                    num++;
                }
            }
            System.out.println(num);

        }
    }
}

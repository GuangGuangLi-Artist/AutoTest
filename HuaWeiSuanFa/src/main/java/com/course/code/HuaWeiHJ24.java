package com.course.code;

import java.util.Scanner;

/**
 * 合唱队
 *
 * 用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
 *
 * 最少需要几位同学出列
 *
 * 8
 * 186 186 150 200 160 130 197 200
 *
 * 4
 */

public class HuaWeiHJ24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        //身高集合
        int [] shengao = new int[n];
        for(int i = 0; i < n; i++){
            shengao[i] = in.nextInt();
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        //左侧递增

        for (int i = 0; i < n; i++) {
            left[i] = 1;
            for (int j = 0; j < n; j++) {
                if(shengao[i] > shengao[j]){
                    left[i] = Math.max(left[i],left[j] + 1);
                }
            }
        }

        //右侧递减
        for (int i = n-1; i >=0 ; i--) {
            right[i] = 1;
            for (int j = n-1; j >= 0; j--) {
                if(shengao[i] > shengao[j]){
                    right[i] = Math.max(right[i],right[j] + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            result[i] = left[i] + right[i] -1;
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(result[i],max);
        }

        System.out.println(max);


    }
}

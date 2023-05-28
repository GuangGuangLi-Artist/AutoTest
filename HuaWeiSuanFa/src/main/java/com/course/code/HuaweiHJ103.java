package com.course.code;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Redraiment的走法
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 *
 * 输入描述：
 * 数据共2行，第1行先输入数组的个数，第2行再输入梅花桩的高度
 *
 * 输出描述：
 * 输出一个结果
 *
 * 输入：
 * 6
 * 2 5 1 5 4 5
 * 输出：
 * 3
 * 说明：
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5 ，下标分别是 1 5 6
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5， 下标分别是 3 5 6
 * 从第5格开始走最多有2步,4 5， 下标分别是 5 6
 * 所以这个结果是3
 */
public class HuaweiHJ103 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int [] zhuangHigh = new int[n];
            for (int i = 0; i < n; i++) {
                zhuangHigh[i] = scanner.nextInt();
            }

            count(zhuangHigh);
        }



    }

    //动态规划最长递增序列
    private static void count(int[] zhuangHigh) {

        int [] dp = new int[zhuangHigh.length];
        //初始化为1
        Arrays.fill(dp,1);
        int max = 1;
        for (int i = 1; i < zhuangHigh.length; i++) {
            for (int j = 0; j < i; j++) {
                if(zhuangHigh[j] < zhuangHigh[i]){// i位置值大于j位置
                    dp[i] = Math.max(dp[i],dp[j] + 1 );//则在j位置的dp值上+1，然后取大的
                }
                max = Math.max(max,dp[i]);
            }
        }
        System.out.println(max);
    }
}

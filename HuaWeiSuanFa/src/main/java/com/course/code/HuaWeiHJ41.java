package com.course.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


/**
 *
 * 称砝码
 *现有n种砝码，重量互不相等，分别为 m1,m2,m3…mn ；
 * 每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 *
 * 注：
 * 称重重量包括 0
 *
 *对于每组测试数据：
 * 第一行：n --- 砝码的种数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])
 *
 * 利用给定的砝码可以称出的不同的重量数
 */
public class HuaWeiHJ41 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //set结构去重
        HashSet<Integer> set = new HashSet<>();

        //初始化为0
        set.add(0);

        int n = scanner.nextInt();
        int[] w = new int[n];
        int [] nums = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt(); //砝码重量
        }

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();//砝码个数
        }

        for (int i = 0; i < n; i++) {//遍历砝码
            List<Integer> list = new ArrayList<>(set);//取当前所有的结果
            for (int j = 1; j <= nums[i]; j++) {//遍历个数
                for (int k = 0; k < list.size(); k++) {
                    //在之前set的结果之上，再累加现有的砝码的重量，从而变成了新的组合
                    set.add(list.get(k) + w[i] * j);

                }
            }
        }

        System.out.println(set.size());
        scanner.close();
    }
}

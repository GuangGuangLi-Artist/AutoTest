package com.course.code;

import java.util.Scanner;

/**
 * 放苹果
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * 注意：如果有7个苹果和3个盘子，（5，1，1）和（1，5，1）被视为是同一种分法。
 * 输入描述：输入两个int整数
 *
 * 输出描述：输出结果，int型
 */

public class HuaweiHJ61 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resource = scanner.nextLine();

        String [] strs = resource.split(" ");

        int apple = Integer.parseInt(strs[0]);
        int plate = Integer.parseInt(strs[1]);

        int res = getCount(apple,plate);
        System.out.println(res);
        scanner.close();









    }

    public static int getCount(int apple,int palte){

        if(apple < 0 || palte < 0){
            return 0;
        }

        //盘子为1个  都放一起
        if(palte == 1){
            return 1;
        }

        if(apple == 1){
            return 1;
        }

        //至少有一个盘子为空
        // 每个盘子至少有一个果子

        return getCount(apple,palte-1) + getCount(apple-palte,palte);
    }
}

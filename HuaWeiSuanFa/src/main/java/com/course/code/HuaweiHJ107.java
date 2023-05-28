package com.course.code;


import java.util.Scanner;

/**
 * 求解立方根
 *
 * 计算一个浮点数的立方根，不使用库函数。
 * 保留一位小数。
 *
 * 输入描述：待求解参数，为double类型（一个实数）
 * 输出描述：输出参数的立方根。保留一位小数。
 *
 * 输入：
 * 19.9
 * 输出：
 * 2.7
 *
 * 二分
 * 具体做法
 * 做过求平方根的同学应该都知道，这题最先想到的应该就是二分法吧。
 *
 * 如果一个数num>1，那么这个数的立方根一定在1~num之间。
 * 如果一个数num<-1，那么这个数的立方根一定在num~-1
 * 如果一个数-1<num<1，那么这个数的立方根一定在-1~1之间 如num = 2.7
 * 可以设置左边界为min(-1,2.7) = -1 右边界 max(1,2.7) = 2.7
 * 所以left = -1，right = 2.7
 */
public class HuaweiHJ107 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.valueOf(scanner.nextLine());
        double res = calc(num);
        System.out.printf("%.1f",res);
        scanner.close();


    }
    public static double calc(double d){
        double left = Math.min(-1,d);
        double right = Math.max(1,d);
        double mid = 0.0;

        while (right - left > 0.001){
            mid = (right + left) / 2;
            if(mid * mid * mid > d){// 说明右边界在mid左侧
                right = mid;
            }else  if(mid * mid * mid < d){
                left = mid;
            }else {
                return  mid;
            }

        }
        return left;

    }
}

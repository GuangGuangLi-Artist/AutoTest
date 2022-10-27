package com.course.code;

import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
 *
 * 数据范围：保证输入的数字在 32 位浮点数范围内
 * 输入描述：
 * 输入一个正浮点数值
 *
 * 输出描述：
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入：
 * 5.5
 * 输出：
 * 6
 * 说明：
 * 0.5>=0.5，所以5.5需要向上取整为6
 * 示例2
 * 输入：
 * 2.499
 * 输出：2

 * 说明：
 * 0.499<0.5，2.499向下取整为2
 */

public class HuaWeiJinSiZhi {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double doNum = scanner.nextDouble();
        System.out.println((int) Math.round(doNum));//round 返回最接近参数的 long。结果将舍入为整数：加上 1/2，对结果调用 floor 并将所得结果强制转换为 long 类型。换句话说，结果等于以下表达式的值：

    }
}

package com.course.code;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 数据范围：保证结果在 1 \le n \le 2^{31}-1 \1≤n≤2
 * 31
 *  −1
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开
 *
 *
 *
 */

public class HuaWeiJinZhiZhuanHuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String sLine = scanner.nextLine();
            //parseInt()使用第二个参数指定的基数，将字符串参数解析为有符号的整数。
            System.out.println(Integer.parseInt(sLine.substring(2,sLine.length()),16));  //java语言中 16进制的数字以0x开头

        }

    }
}

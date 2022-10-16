package com.course.code;

import java.util.Scanner;

/**
 * 描述
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 *
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *
 * 数据范围：保证输入的是合法的 IP 序列
 *
 * 输入描述：
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 * 输出描述：
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 *
 * 示例1
 * 输入：
 * 10.0.3.193
 * 167969729
 * 输出：
 * 167773121
 * 10.3.3.193
 */

public class HuaWeiIpInteger {

    private  final static  int N = 4;

    public   static String convertIp(String str){
        // ip4 > int
        if(str.contains(".")){
            String [] fileds = str.split("\\.");
            long res = 0;
            for (int i = 0; i < N; i++) {
                res = res * 256 + Integer.parseInt(fileds[i]);

            }
            return "" + res;
        }else {
         long ipv4 = Long.parseLong(str);
         String res = "";
            for (int i = 0; i < N; i++) {
                res = ipv4 % 256 + "." + res;
                ipv4 /= 256;
            }
            return res.substring(0,res.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            String res = convertIp(str);
            System.out.println(res);

        }
    }




}

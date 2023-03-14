package com.course.code;

import java.util.Scanner;

/**
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 * 0即不是正整数，也不是负数，不计入计算。如果没有正数，则平均值为0。
 */

public class HuaweiHJ97 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());
            String res = scanner.nextLine();
            String [] strs = res.split(" ");
            int fu = 0;
            double avg = 0.0;
            int zero = 0;
            double sum = 0.0;

            for (int i = 0; i < strs.length; i++) {
                if(Integer.parseInt(strs[i]) < 0){
                    fu++;
                }else if(Integer.parseInt(strs[i]) == 0){
                    zero++;
                }else {
                  sum += Integer.parseInt(strs[i]);
                }
            }
            if(sum == 0.0){
                avg = 0.0;
            }else {
                avg = sum / (n - (fu + zero));
            }

            System.out.println(fu + " " + String.format("%.1f",avg));


        }

    }
}

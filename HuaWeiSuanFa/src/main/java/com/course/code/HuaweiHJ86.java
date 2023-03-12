package com.course.code;

import java.util.Scanner;

/**
 * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 */

public class HuaweiHJ86 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        String newNum = Integer.toBinaryString(num);



        //按照0分割字符串
        String[] sArr = newNum.split("0");
        int max = 0;
        for (String str: sArr){
            if(str.contains("1")){
                max = Math.max(max,str.length());

            }
        }

        System.out.println(max);

        scanner.close();



    }
}

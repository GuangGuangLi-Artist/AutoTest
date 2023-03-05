package com.course.code;

import java.util.Scanner;

/**
 * 描述
 * 根据输入的日期，计算是这一年的第几天。
 * 保证年份为4位数且日期合法。
 * 输入描述：
 * 输入一行，每行空格分割，分别是年，月，日
 *
 * 输出描述：
 * 输出是这一年的第几天
 *
 * 输入：2012 12 31
 * 输出：366
 */
public class HuaweiHJ73 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String resorce = in.nextLine();
            String[] strArr = resorce.split(" ");
            int year = Integer.parseInt(strArr[0]);
            int month = Integer.parseInt(strArr[1]);
            int day = Integer.parseInt(strArr[2]);
            int[] month_day = {31,28,31,30,31,30,31,31,30,31,30,31};
            int sum = 0;
            for (int i = 0; i < month -1; i++) {
                sum += month_day[i];
            }
            sum += day;
            if(month > 2 && getIsRun(year)){
                sum += 1;
            }
            System.out.println(sum);

        }

    }

    public static boolean getIsRun(int year){

        // ①非世纪年能被4整除，且不能被100整除的是闰年。（如2004年是闰年，1901年不是闰年）
        // ②世纪年能被400整除的是闰年。（如2000年少闰年，1900年不是闰年）
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            return true;
        }else {
            return false;
        }


    }
}

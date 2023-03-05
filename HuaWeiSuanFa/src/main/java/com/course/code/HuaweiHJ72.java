package com.course.code;

import java.util.Scanner;

/**
 * 公元五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * 现要求你打印出所有花一百元买一百只鸡的方式。
 *
 *输入描述：
 * 输入任何一个整数，即可运行程序。
 * 输出描述：
 * 输出有数行，每行三个整数，分别代表鸡翁，母鸡，鸡雏的数量
 */
public class HuaweiHJ72 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 用a表示鸡翁1只5元；用b代表鸡母1只3元；用c代表鸡雏3只1元
        // 所以100元全部买a，能买20只；全部买b能买33只；全部买c能买300只
        // 那么就穷举吧
        for (int a = 0; a<= 20; a++){
            for (int b = 0; b <= 33; b++) {
                for (int c = 0; c <=300 ; c++) {// 全部买c能买300只,但因为题目应该规定是买100只，所以到不了300只这个情况
                    if(a + b + c == 100){
                        if((c % 3 == 0) && (a*5 + b*3 + (c / 3))==100){
                            System.out.println(a + " " + b + " " + c);
                        }
                    }

                }
            }
        }
        scanner.close();
    }


}

package com.course.code;

import java.util.Scanner;

/**
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * 例如，当输入5时，应该输出的三角形为：
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 *
 *
 * 输入：4
 * 输出：1 3 6 10
 *      2 5 9
 *      4 8
 *      7
 *
 *
 * 注意观察蛇形矩阵的规律。数字1代表第1个要填入的位置，其坐标为(0,0)；数字2代表第2个要填入的位置，其坐标为(0,1)；数字3代表第3个要填入的位置，
 * 其坐标为(1,0)；数字4代表第4个要填入的位置，其坐标为(0,2)；数字5代表第5个要填入的位置，其坐标为(1,1)；数字6代表第6个要填入的位置，
 * 其坐标为(2,0)......因此类推。假设(x,y)代表坐标，则填完该(x,y)的下一个位置是(x+1,y-1)，直到y为0为止。
 */

public class HuaweiHJ35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //二维数组表达蛇形矩阵
        int[][] out = new int[n][n];

        //数据填充
        int value = 1;
        for (int i = 0; i < n; i++) {
            //初始位置
            int x = i;
            int y = 0;
            while (y < n && x >= 0){
                out[x][y] = value;
                x--;
                y++;
                value++;
            }
        }

        //输出
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n-i; j++) {
                if(out[i][j] != 0){
                    sb.append(out[i][j] + " ");
                }
            }
            System.out.println(sb.toString().trim());
        }

    }
}

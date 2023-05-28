package com.course.code;


import java.util.Scanner;

/**
 *
 * 矩阵乘法
 *如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
 *
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 * 之后x行，每行y个整数，代表第一个矩阵的值
 * 之后y行，每行z个整数，代表第二个矩阵的值
 *
 * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 */
public class HuaweiHJ69 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();  //第一个矩阵行
        int y = sc.nextInt();  //第一个矩阵列，  第二个矩阵的行
        int z = sc.nextInt();  //第二个矩阵的列

        int[][] first = new int[x][y];
        int[][] second = new int[y][z];
        int[][] third = new int[x][z];

        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                first[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<y; i++) {
            for(int j =0; j<z; j++) {
                second[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<x; i++) {
            for(int j=0; j<z; j++){
                for(int k=0; k<y; k++) {
                    third[i][j] = third[i][j] + first[i][k] * second[k][j];
                }
                //i=0行时，0，1，2，z-1列位置的值显示
                System.out.print(third[i][j] + " ");
            }
            // i=0行 遍历完后，换行显示
            System.out.println();
        }
    }
}

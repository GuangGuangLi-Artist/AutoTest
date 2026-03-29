package niukeans;

import java.util.Scanner;

public class HJ35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //创建 n x n 矩阵（索引从1开始方便，或用0-based）
        int[][] matrix = new int[n + 1][n + 1];

        int num = 1;

        for (int group = 1; group <= n; group++) {
            // 起始位置：(group, 1)
            int row = group;
            int col = 1;

            // 填充 group 个元素
            for (int i = 0; i < group; i++) {
                matrix[row][col] = num++;
                row--;// 向上一行
                col++;// 向右一列
            }
        }
        //输出：第 i 行输出前 (n - i + 1) 个元素
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(matrix[i][j]);
                if(j < n - i + 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

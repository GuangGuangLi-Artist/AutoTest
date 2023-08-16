package com.course.code.codeArray;

/**
 * 59 螺性矩阵
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 
 * 
 */
public class GenerateMatrix {

    public static void main(String[] args) {

        int[][] nums = generateMatrix(4);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;// 定义填充数字
        int start = 0;// 每次循环的开始点(start, start)
        int loop = 0;// 控制循环次数
        int i,j;
        
        while (loop++ < n / 2) {// 判断边界后，loop从1开始
            //上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }
            
            //右侧从上到下
            for ( i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            //下方从右到左
            for (;j >= loop; j-- ) {
                res[i][j] = count++;
            }

            //左侧从下到上
            for (;i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;

        }

        if(n % 2 == 1) {
            res[start][start] = count;
        }
        return res;
    }
    
}



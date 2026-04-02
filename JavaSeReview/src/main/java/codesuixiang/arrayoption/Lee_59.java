package codesuixiang.arrayoption;

import java.util.Arrays;

/**
 * 59 螺旋矩阵
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 1 2 3  nums[0][0] = 1 nums[0][1] = 2 nums[0][2] = 3
 * 8 9 4  nums[1][0] = 8 nums[1][1] = 9 nums[1][2] = 4
 * 7 6 5  nums[2][0] = 7 nums[2][1] = 6 nums[2][2] = 5
 *
 * 题解 循环不变量原则。
 *
 */
public class Lee_59 {
    public static void main(String[] args) {

        int[][] ints = creatArray(3);
        System.out.println(Arrays.deepToString(ints));

    }

    public static  int[][] creatArray(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;// 每一圈的起始点
        int offset = 1;// 需要控制每一条边遍历的长度，每次循环右边界收缩一位
        int count = 1;// 矩阵中需要填写的开始数字
        int loop = 1;// 记录当前的圈数
        int i,j;// j 代表列, i 代表行

        while (loop <= n / 2) {
            //顶部
            //左闭右开，所以判断循环结束时，j不能等于 n - offset
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            //右列
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            // 底部
            // 左闭右开，所以判断循环结束时， j != startY
            for (;j > startY; j--){
                /**
                 *  ; (初始化缺失): 注意 for 后面的第一个分号前是空的。这意味着循环直接使用变量 j 的当前值，而不在循环开始时重新赋值。
                 *  通常在进入这个循环之前，j 已经在上一个循环（比如“从下向上”或“从左向右”）结束后停留在了一个特定的位置。
                 */
                nums[i][j] = count++;

            }

            for (;i > startX;i--){
                nums[i][j] = count++;
            }

            startX++;
            startY++;
            offset++;
            loop++;
        }

        if(n % 2 == 1){// n 为奇数时，单独处理矩阵中心的值
            nums[startX][startY] = count;
        }
        return nums;

    }
}

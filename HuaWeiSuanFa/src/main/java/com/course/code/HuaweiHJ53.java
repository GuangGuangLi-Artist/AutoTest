package com.course.code;

import java.util.Scanner;

/**以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，
 * 左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
 * 输入n(n <= 1000000000)
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)等方式读入
 * 输入描述:输入一个int整数
 * 输出描述:输出返回的int值
 * 示例1
 * 输入
 * 4
 * 输出
 * 3
 *
 * 解题思路
 * 该题转为了，第n行的数字序列是什么？如果求得了第n行的数字序列，那么从这个数字序列里面找第1个偶数就简单了。
 *
 * 那么如何来生成第n行的数字序列？
 *
 * 观察得知，第n行是上一行个数加2，就是说，第n行有(n-1)*2 +1 个数字，上述问题可以转为了n 乘以 (n-1)*2 +1 的矩阵问题。
 *
 * 矩阵为空的赋值0；
 * 计算时先算第1行，再算第2行，因此类推，算到n行为止。
 * 每行的数字序列都是左右对称的，先找到要计算的起止位置。开始位置是上一行的开始位置左移一位；截止位置是上一行的截止位置右移一位
 */

public class HuaweiHJ53 {

    public static void main(String[] args) {
        //输入
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){
            int num = scanner.nextInt();
            if(num == 1 || num == 2){
                System.out.println(-1);
                continue;
            }else  if(num % 4 == 1 || num % 4 == 3){
                System.out.println(2);
                continue;
            }else if(num % 4 == 0){
                System.out.println(3);
                continue;
            }else if(num % 4 == 2){
                System.out.println(4);
                continue;
            }
        }
        scanner.close();
    }

}

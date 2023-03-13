package com.course.code;

import java.util.Scanner;

/**
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）从棋盘左上角出发沿着边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 * 输入两个正整数n和m，用空格隔开。(1≤n,m≤8)
 * 输出一行结果
 *
 *
 * 把问题解法定为f(n,m),从左上角第1个点开始，
 * 如果往右走1步，剩下的问题就变成了f(n-1,m);
 * 如果一开始往下走一步，剩下的问题就变成f(n,m-1),
 * 一直递归，就有了f(n,m)=f(n-1,m)+f(n,m-1)。
 */

public class HuaweiHJ91 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(cal(m,n));
        }

    }

    public static int cal(int m,int n){
        if(m ==1 || n ==1){
            return  m + n;
        }
        return cal(m-1,n) + cal(m,n-1);
    }
}

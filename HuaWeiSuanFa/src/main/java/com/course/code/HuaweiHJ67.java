package com.course.code;

import java.util.Scanner;

/**
 * 给出4个1-10的数字，通过加减乘除运算，得到数字为24就算胜利,除法指实数除法运算,运算符仅允许出现在两个数字之间,本题对数字选取顺序无要求，但每个数字仅允许使用一次，且需考虑括号运算
 * 此题允许数字重复，如3 3 4 4为合法输入，此输入一共有两个3，但是每个数字只允许使用一次，则运算过程中两个3都被选取并进行对应的计算操作。
 *
 * 读入4个[1,10]的整数，数字允许重复，测试用例保证无异常数字。
 *
 * 对于每组案例，输出一行表示能否得到24点，能输出true，不能输出false
 *
 * 7 2 1 10
 * true
 */
public class HuaweiHJ67 {

    static int[] nums = new int[4];  // 存放输入数字
    static boolean[] visit = new boolean[4]; // 存放对应位置数字是否使用标志
    static int flag = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext() && flag ==0){
            String[] input = sc.nextLine().split(" ");
            for(int i = 0; i < 4; i ++)
                nums[i] = Integer.parseInt(input[i]);
            dfs(0, 0);
            System.out.println( flag == 1 );
        }

    }

    // tmp是前面n个数字运算结果，u表示已经使用了多少个数字
    public static boolean dfs(int u, float tmp) {
        //递归出口，数字已用完且结果为24
        if(u == 4 && tmp ==24) {
            flag = 1;
            return true;
        }

        // 对四个数字递归
        for(int i = 0; i < 4; i++) {
            if(visit[i]  == false) { // 当前数字标志位是：未使用
                visit[i] = true;  // 更新为已使用
                if(dfs(u+1, tmp + nums[i]) ||
                        dfs(u+1, tmp - nums[i]) ||
                        dfs(u+1, tmp * nums[i]) ||
                        dfs(u+1, tmp / nums[i])) {
                    return true;
                }
                // 相当于回溯
                visit[i] = false;
            }
        }
        return false;
    }
}

package com.course.code;

import java.util.Scanner;

/**
 *验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 * 1^3=1
 * 2^3=3+5
 * 3^3=7+9+11
 * 4^3=13+15+17+19
 *
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 */
public class HuaweiHJ76 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        //观察规律 第n行的首个数字，与n-1的首个数字差值是2(n-1)
        int first = getResult(num);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(first);

        //后续每个值与前一个值差2
        for (int i = 1; i < num; i++) {
            stringBuffer.append("+");
            int newNum = 2*i + first;
            stringBuffer.append(newNum);

        }
        System.out.println(stringBuffer.toString());
        scanner.close();



    }

    public static  int getResult(int n){
        if(n == 0){
            return 1;
        }else {
            return getResult(n-1) + 2*(n-1);
        }
    }
}

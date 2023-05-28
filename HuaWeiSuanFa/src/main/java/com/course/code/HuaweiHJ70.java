package com.course.code;

import java.util.Scanner;
import java.util.Stack;

/**
 * 矩阵乘法计算量估算
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * 例如：
 *
 * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 *
 * 计算A*B*C有两种顺序：((AB)C)或者(A(BC))，前者需要计算15000次乘法，后者只需要3500次。
 *
 * 编写程序计算不同的计算顺序需要进行的乘法次数。
 * 输入描述
 * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 * 计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
 *
 * 输出描述
 * 输出需要进行的乘法次数
 *
 * 输入：
 * 3
 * 50 10
 * 10 20
 * 20 5
 * (A(BC))
 *
 * 输出：
 * 3500
 */
public class HuaweiHJ70 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[][] input = new int[n][2];
            for(int i=0; i<n; i++) {
                for(int j=0; j<2; j++) {
                    input[i][j] = sc.nextInt();
                }
            }
            //输入规则
            String rule = sc.next();
            System.out.println(caculate(input, rule));
        }
    }

    public static int caculate(int[][] dp, String rule) {
        int res =0;

        //解析规则，双栈法：一个栈用来存括号，另一个用来存矩阵中的行
        Stack<int[]> stack1 = new Stack<>();  //存放矩阵行
        Stack<Character> stack2 = new Stack<>();  //存括号

        for(int i=0; i<rule.length(); i++) {
            char c = rule.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                stack1.push(dp[c-'A']);
            }else if(c == '(') { //左括号
                stack2.push(c);
            }else if(c == ')' && !stack2.isEmpty()) {
                stack2.pop();
                //右括号且stack2中还有（，弹出stack1中行，并且遵循后入先出的规则
                //以（A(BC)）为例，则先弹出的是C，后弹出的是B
                int[] n2 = stack1.pop();  //C(20,5)
                int[] n1 = stack1.pop();  //B(10,20)
                //更新结果
                res = res + n1[0] * n1[1] * n2[1];
                //将BC得到的结果添加到stack1中
                int[] tem = {n1[0],n2[1]};
                stack1.push(tem);  //BC(10,5)
            }
        }
        return res;
    }
}

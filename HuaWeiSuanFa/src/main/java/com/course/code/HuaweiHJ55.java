package com.course.code;

import java.util.Scanner;
import java.util.Stack;

/**
 *  表达式求值
 *
 *  给定一个字符串描述的算术表达式，计算出结果值。
 *
 * 输入字符串长度不超过 100 ，合法的字符包括 ”+, -, *, /, (, )” ， ”0-9” 。
 *
 * 数据范围：运算过程中和最终结果均满足∣val∣≤2e31−1  ，即只进行整型运算，确保输入的表达式合法
 * 输入描述：
 * 输入算术表达式
 *
 * 输出描述：
 * 计算出结果值
 * 解题步骤
 * 初始化两个栈operatorStack、numberStack，分别用于存放运算符和数字。
 * 接收这一整串的字符串，并从第一个字符开始，遍历字符串。
 * 不管是大、中、小括号，处理方式一样，遇到左括号，忽略。
 * 遇到数字，存入数字栈；遇到运算符，存入运算符栈。
 * 不管是大、中、小括号，处理方式一样，，遇到右括号，开始计算，取出数字栈最顶上两个元素，以及运算符栈最顶上一个元素，用数字栈倒数第二个元素通过运算符和第一个元素进行运算。
 * 将计算的结果再压入数字栈。
 * 重复2-5，直到遇到最后一个括号，则计算结束，返回最终数字栈中的唯一元素
 */

public class HuaweiHJ55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        //中括号、大括号全部转为小括号，方便处理

        str = str.replace('[','(');
        str = str.replace(']',')');
        str = str.replace('{','(');
        str = str.replace('}',')');

        //为了统一计算逻辑，在最外面的表达式也放括号
        if(str.charAt(0) != '('){
            str = '(' + str + ')';
        }

        //输出
        System.out.println(solve(str));

        in.close();


    }

    private static int solve(String str) {

        char[] chars = str.toCharArray();
        int length = chars.length;

        Stack<Integer> stack = new Stack<>();

        //记录数字
        int num = 0;

        //记录上个操作符
        char opr = '+';

        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            // 一直入栈
            // 遇到右括号就出栈，直到左括号出现为止
            // 括号内包裹的表达式进行计算
            // 如果当前字符是小括号
            if(ch=='('){
                //移到小括号后一位字符
                int j = i + 1;
                //统计括号的数量
                int count = 1;
                while (count>0){
                    //遇到右括号，括号数-1
                    if(chars[j] == ')'){
                        count--;
                    }

                    // 遇到左括号，括号数+1
                    if(chars[j] == '('){
                        count++;
                    }
                }
                //递归，解小括号中的表达式
                num = solve(str.substring(i + 1, j - 1));
                i = j -1;
            }else if( Character.isDigit(ch)){
                // 多为数字的处理，ch-'0'是转为整数
                num = num * 10 + ch - '0';
            }

            if(Character.isDigit(ch) || i == length -1){
                // 遇到符号，将数字处理后放进栈
                // 如果是'+',直接入栈
                if(opr == '+'){
                    stack.push(num);
                }else  if(opr == '-'){// 如果是'-',数字取相反数在入栈
                    stack.push(-1 * num);
                }else if(opr == '/'){// 如果是'/',弹出一个数字/后放入栈
                    stack.push(stack.pop() / num);
                }
                // 更新符号
                opr = ch;

                //刷新数字
                num = 0;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;

    }
}

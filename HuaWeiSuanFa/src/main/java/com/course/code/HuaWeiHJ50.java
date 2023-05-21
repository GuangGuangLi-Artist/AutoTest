package com.course.code;


import java.util.Scanner;
import java.util.Stack;

/**
 * 四则运算
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 *
 * 输入一个算术表达式
 * 得到计算结果
 */
public class HuaWeiHJ50 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        //中括号 大括号 小括号 全部转为小括号方便处理
        str = str.replace("{","(");
        str = str.replace("[","(");
        str = str.replace("}",")");
        str = str.replace("]",")");

        //为了方便统一计算逻辑，最外面的表达式也放括号
        if(str.charAt(0) != '('){
            str = '(' + str + ')';
        }

        //输出
        System.out.println(solve(str));

        scanner.close();
    }

    private static int solve(String str) {

        char[] chs = str.toCharArray();
        int length = chs.length;

        //使用栈存放数字
        Stack<Integer> stack = new Stack<>();

        //记录数字
        int number = 0;

        //记录上个操作符
        char opr = '+';

        for (int i = 0; i < length; i++) {
            char ch = chs[i];

            //一直入栈 遇到右括号就出栈，直到左括号出现为止，括号内包裹的表达式进行计算
            //如果当时字符是小括号
            if(ch == '('){

                //移到小括号最后一位字符
                int j = i + 1;

                //统计括号的数量
                int count = 1;
                while (count > 0){
                    //遇到右括号 括号数减一
                    if(chs[j] == ')'){
                        count--;
                    }
                    //遇到左括号 括号数加一
                    if(chs[j] == '('){
                        count++;
                    }
                    j++;
                }
                //递归 解小括号中的表达式
                number = solve(str.substring(i+1,j-1));
                i = j -1;

            }else if(Character.isDigit(ch)){
                //多位数字的处理，ch - '0' 是转为整数
                number = number * 10 + ch - '0';
            }

            if(!Character.isDigit(ch) || i == length -1){
                //遇到符号，将数字处理后放进栈

                //如果是+ 直接入栈
                if(opr == '+'){
                    stack.push(number);
                }
                // 如果是'-',数字取相反数在入栈
                else if(opr == '-'){
                    stack.push(-1 * number);
                }

                // 如果是'*',弹出一个数字乘后放入栈
                else if(opr == '*'){
                    stack.push(stack.pop() * number);
                }
                // 如果是'/',弹出一个数字/后放入栈
                else if (opr == '/'){
                    stack.push(stack.pop() / number);
                }

                //更新符号
                opr = ch;

                //刷新数字
                number = 0;
            }
        }

        // 栈中数字求和得到结果
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }


        return sum;
    }


}

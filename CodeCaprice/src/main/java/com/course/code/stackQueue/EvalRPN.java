package com.course.code.stackQueue;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 150 逆波兰表达式求值
 *     根据 逆波兰表示法，求表达式的值。
 *     有效的运算符包括 + ,  - ,  * ,  / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *     整数除法只保留整数部分。 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *    示例 1：
 *        输入: ["2", "1", "+", "3", " * "]
 *        输出: 9
 *        解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 *       逆波兰表达式主要有以下两个优点：
 *           去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 *           适合用栈操作运算：遇到数字则入栈；遇到运算符则取出栈顶两个数字进行计算，并将结果压入栈中
 */
public class EvalRPN {

    public static void main(String[] args) {
        String[] strs = {"4", "13", "5", "/", "+"};
        int rpn = evalRPN(strs);
        System.out.println(rpn);

    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();  //Deque是
        for (String token : tokens) {
            if("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            }else if("-".equals(token)) {
                stack.push(-stack.pop() + stack.pop());
            }else if("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            }else if("/".equals(token)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }


}

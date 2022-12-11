package com.course.code.oneThree;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 栈：
 * 后进先出
 * 压栈
 */
public class StackReverse {

    public static void main(String[] args) {

        Stack<Integer> stack;
        stack = new Stack<Integer>();
        while (!StdIn.isEmpty()){
            stack.push(StdIn.readInt());
        }
        for (int i: stack){
            StdOut.println(i);
        }
    }
}

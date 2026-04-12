package codesuixiang.stackDeeque;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 */
public class Lee_232 {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public Lee_232() {
        stackIn = new Stack<>();// 负责进栈
        stackOut = new Stack<>();// 负责出栈

    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }


    public void dumpstackIn(){
        if(!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }


}

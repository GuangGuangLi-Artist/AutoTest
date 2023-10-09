package com.course.code.stackQueue;


import java.util.Stack;

/**
 * 232 用栈实现队列
 *     使用栈实现队列的下列操作：
 *     push(x) -- 将一个元素放入队列的尾部。
 *     pop() -- 从队列首部移除元素。
 *     peek() -- 返回队列首部的元素。
 *     empty() -- 返回队列是否为空。
 *     示例:
 *     MyQueue queue = new MyQueue();
 *     queue.push(1);
 *     queue.push(2);
 *     queue.peek();  // 返回 1
 *     queue.pop();   // 返回 1
 *     queue.empty(); // 返回 false
 */
public class MyQueue {

    /**
     * 在push数据的时候，只要数据放进输入栈就好，但在pop的时候，操作就复杂一些，输出栈如果为空，就把进栈数据全部导入进来（注意是全部导入），
     * 再从出栈弹出数据，如果输出栈不为空，则直接从出栈弹出数据就可以了。
     *
     * 最后如何判断队列为空呢？如果进栈和出栈都为空的话，说明模拟的队列为空了。
     *
     */
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();//负责进栈
        stackOut = new Stack<>();//负责出栈
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }


    //如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
    private void dumpStackIn() {
        if(!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}

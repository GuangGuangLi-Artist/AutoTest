package codesuixiang.stackDeeque;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 */
public class Lee_225 {

    Queue<Integer> queue1;// 和栈中保持一样元素的队列
    Queue<Integer> queue2;// 辅助队列

    public Lee_225() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList();
    }


    public void push(int x) {
        queue2.offer(x);// 先放在辅助队列中
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp;// 最后交换queue1和queue2，将元素都放到queue1中
    }

    public int pop() {
        return queue1.poll();// 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可

    }

    public int top(){
        return queue1.peek();
    }
    public boolean isEmpty(){
        return queue1.isEmpty();
    }
}

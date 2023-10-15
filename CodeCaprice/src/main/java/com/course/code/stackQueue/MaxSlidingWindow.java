package com.course.code.stackQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 *
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] window = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(window));
    }

    public static int[] maxSlidingWindow(int[] nums,int k) {
        if(nums.length == 1) {
            return nums;
        }

        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        int num = 0;
        MyQueueSingle myQueueSingle = new MyQueueSingle();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueueSingle.add(nums[i]);
        }

        res[num++] = myQueueSingle.peek();
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            myQueueSingle.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueueSingle.add(nums[i]);

            //记录对应的最大值
            res[num++] = myQueueSingle.peek();
        }
        return res;
    }
}

class MyQueueSingle{

    /**
     * 设计单调队列的时候，pop，和push操作要保持如下规则：
     *     pop(value)：如果窗口移除的元素value等于单调队列的出口元素，那么队列弹出元素，否则不用任何操作
     *     push(value)：如果push的元素value大于入口元素的数值，那么就将队列入口的元素弹出，直到push元素的数值小于等于队列入口元素的数值为止
     */
    Deque<Integer> deque = new LinkedList<>();
    //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    //同时判断队列当前是否为空
    void poll (int val) {
        if( !deque.isEmpty() && val == deque.peek()) {
            deque.poll();//删除队列开头的元素
        }
    }


    //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    //保证队列元素单调递减
    //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
        }

    //队列队顶元素始终为最大值
    int peek() {
        return deque.peek();
    }
}



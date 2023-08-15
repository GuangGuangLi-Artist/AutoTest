package com.course.code.codeArray;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        System.out.println(minSubArrayLenMovingWindow(s,nums));

    }

    //滑动窗口法
    public static int minSubArrayLenMovingWindow(int s, int[] nums) {
        /**
         * 所谓滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果。
         * 在暴力解法中，是一个for循环滑动窗口的起始位置，一个for循环为滑动窗口的终止位置，用两个for循环 完成了一个不断搜索区间的过程。
         * 在本题中实现滑动窗口，主要确定如下三点：
             - 窗口内是什么？
             - 如何移动窗口的起始位置？
             - 如何移动窗口的结束位置？
         * 窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
         * 窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。
         * 窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引。
         */

        int result = Integer.MAX_VALUE; //最终结果
        int i = 0;//子序列的起始位置
        int subArrLen = 0;//子数组的长度
        int sum = 0; //子序列的和
        for (int j = 0; j < nums.length; j++) {//子序列的终点指针
            sum += nums[j]; //累加
            while (sum >= s) {
                subArrLen = j - i + 1;
                result = result < subArrLen ? result : subArrLen;
                sum = sum  - nums[i];
                i++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}





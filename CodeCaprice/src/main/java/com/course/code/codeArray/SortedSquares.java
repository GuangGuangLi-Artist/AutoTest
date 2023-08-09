package com.course.code.codeArray;

import java.util.Arrays;

/**
 * 977 有序数组的平方和
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class SortedSquares {

    public static void main(String[] args) {

        int[] nums = {-7,-3,2,3,11};
        int[] result = sortedSquareDoublePoint(nums);
        System.out.println(Arrays.toString(result));


    }

    public static int[] sortedSquareDoublePoint(int[] nums ) {

        int k = nums.length - 1;
        int[] res = new int[nums.length];
        for (int i = 0, j = nums.length - 1; i <= j;) {
            if(nums[i] * nums[i] < nums[j] * nums[j]) {
                res[k--] = nums[j] * nums[j];
                j--;
            }else {
                res[k--] = nums[i] * nums[i];
                i++;
            }
        }
        return res;

    }
}

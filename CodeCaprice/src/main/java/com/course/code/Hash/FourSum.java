package com.course.code.Hash;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  18 四数之和
 *      题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与
 *      target 相等？找出所有满足条件且不重复的四元组。
 *    示例： 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。 满足要求的四元组集合为： [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 *
 */
public class FourSum {

    @Test
    public void testFourSum() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> fourSum = fourSum(nums, 0);
        System.out.println(fourSum.toString());
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            // nums[i] > target 直接返回, 剪枝操作
            if(nums[i] > 0 && nums[i] > target) {
                return result;
            }

            if(i > 0 && nums[i - 1] == nums[i]) {// 对nums[i]去重
                continue;
            }

            for (int j = i+1; j < nums.length; j++) {
                if(j > i + 1 && nums[j - 1] == nums[j]) {// 对nums[j]去重
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    // nums[j] + nums[i] + nums[left] + nums[right] > target int会溢出
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target) {
                        right--;
                    }else if(sum < target) {
                        left++;
                    }else {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        left++;
                        right--;
                    }
                }
            }

        }
        return result;
    }
}

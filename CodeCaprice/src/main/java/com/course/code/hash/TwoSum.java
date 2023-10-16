package com.course.code.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1 两数之和
 *     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *     你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *     给定 nums = [2, 7, 11, 15], target = 9
 *     因为 nums[0] + nums[1] = 2 + 7 = 9
 *     所以返回 [0, 1]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] ts = {2, 7, 11, 15};
        int[] res = twoSum(ts,9);
        System.out.println(Arrays.toString(res));

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> twoMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(twoMap.containsKey(temp)) {
                res[1] = i;
                res[0] = twoMap.get(temp);
                break;
            }
            twoMap.put(nums[i], i);

        }
        return res;
    }
}

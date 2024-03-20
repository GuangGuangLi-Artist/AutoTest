package com.course.code.backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90.子集II
 *      给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *      说明：解集不能包含重复的子集。
 *      输入: [1,2,2]
 *      输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
public class SubsetsHelperII {

    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] used;

    public List<List<Integer>> subSetsWithDup(int[] nums) {
        if (nums.length == 0) {
            result.add(path);
            return result;
        }

        Arrays.sort(nums);
        used = new boolean[nums.length];
        subSetBack(nums,0);
        return result;
    }

    private void subSetBack(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            subSetBack(nums,i+1);
            path.removeLast();
            used[i] = false;
        }
    }
}

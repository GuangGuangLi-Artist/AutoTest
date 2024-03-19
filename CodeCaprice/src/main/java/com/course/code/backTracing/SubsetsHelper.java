package com.course.code.backTracing;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78.子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例: 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
 */
public class SubsetsHelper {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums,0);
        return result;
    }

    private void backTracking(int[] nums, int stratIndex) {
        result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (stratIndex > nums.length) {
            return;
        }

        for (int i = stratIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums,i+1);
            path.removeLast();
        }
    }
}

package com.course.code.backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47.全排列 II
 *     给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *     输入：nums = [1,1,2]
 *     输出： [[1,1,2], [1,2,1], [2,1,1]]
 *
 */
public class PerMuteII {
    List<List<Integer>> result = new ArrayList<>();
    //暂存结果
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTrack(nums, used);
        return result;
    }

    private void backTrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i-1] == nums[i] && used[i-1] == false) {
                continue;
            }

            if (used[i] == false) {
                used[i] = true;
                path.add(nums[i]);backTrack(nums,used);
                path.remove(path.size() -1);
                used[i] = false;
            }

        }
    }
}

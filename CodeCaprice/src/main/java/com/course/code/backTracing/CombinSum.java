package com.course.code.backTracing;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  39. 组合总和
 *      给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *      candidates 中的数字可以无限制重复被选取。
 *
 *      输入：candidates = [2,3,6,7], target = 7,
 *      所求解集为： [ [7], [2,2,3] ]
 */
public class CombinSum {
    public List<List<Integer>> combinationSum(int[] condidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(condidates);
        backTracking(res,new ArrayList<>(),condidates,target,0,0);
        return res;
    }

    private void backTracking(List<List<Integer>> res, ArrayList<Integer> path, int[] condidates, int target, int sum, int index) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < condidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + condidates[i] > target) break;
            path.add(condidates[i]);
            backTracking(res, path, condidates, target, sum + condidates[i], i);
            path.remove(path.size() - 1);// 回溯，移除路径 path 最后一个元素

        }

    }
}

package com.course.code.backTracing;


import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216.组合总和III
 *     找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *     示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
 *     示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinSumIII {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1,0);
        return res;
    }

    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        if (sum > targetSum) {
            return;
        }

        if (path.size() > k) {
            return;
        }

        if (path.size() == k){
            if (sum == targetSum) {
                res.add(new ArrayList<>(path));
                return;
            }
        }
        for (int i = startIndex; i <= 9 ; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum,k,i+1,sum);
            sum -= i;
            path.removeLast();
        }

    }

    @Test
    public void testCombinSum() {
        CombinSumIII cs = new CombinSumIII();
        List<List<Integer>> lists = cs.combine(6, 3);
        System.out.println(StringUtils.join("",lists.toString()));
    }
}

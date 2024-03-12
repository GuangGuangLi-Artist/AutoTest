package com.course.code.backTracing;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40.组合总和II
 *     给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *     candidates 中的每个数字在每个组合中只能使用一次。
 *     输入: candidates = [10,1,2,7,6,1,5], target = 8,
 *     [
 *          [1, 7],
 *          [1, 2, 5],
 *          [2, 6],
 *          [1, 1, 6]
 *    ]
 *
 *    本题的难点在于区别2中：集合（数组candidates）有重复元素，但还不能有重复的组合。
 */
public class CombinSumII {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combination(int[] arrs,int target ) {
        used = new boolean[arrs.length];
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used,false);
        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(arrs);
        backTracking(arrs,target,0);
        return res;

    }

    private void backTracking(int[] arrs, int target, int stratIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }

        for (int i = stratIndex; i < arrs.length; i++) {
            if (sum + arrs[i] > target) {
                break;
            }

            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && arrs[i] == arrs[i-1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            sum += arrs[i];
            path.add(arrs[i]);
            // 每个节点仅能选择一次，所以从下一位开始
            backTracking(arrs,target,i+1);
            used[i] = false;
            sum -= arrs[i];
            path.removeLast();
        }
    }


    @Test
    public void testGetConbination() {
        CombinSumII cb2 = new CombinSumII();
        int[] arrs = {10,1,2,7,6,1,5};
        List<List<Integer>> combination = cb2.combination(arrs, 8);
        System.out.println(StringUtils.join("",combination.toString()));
    }

}

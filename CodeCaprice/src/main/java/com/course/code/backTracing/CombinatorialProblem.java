package com.course.code.backTracing;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 第77题. 组合问题
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */
public class CombinatorialProblem {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n,int k) {
        backTrackintg(n,k,1);
        return res;
    }

    private void backTrackintg(int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTrackintg(n,k,i+1);
            path.removeLast();
        }
    }


    @Test
    public void testCombinatorialProblem() {
        CombinatorialProblem cp = new CombinatorialProblem();
        List<List<Integer>> combines = cp.combine(4, 2);
        System.out.println(String.join("",combines.toString()));
    }
}

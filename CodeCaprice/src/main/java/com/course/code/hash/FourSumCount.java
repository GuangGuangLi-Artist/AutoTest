package com.course.code.hash;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 454 四数相加
 *     给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *     为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
 */
public class FourSumCount {

    @Test
    public void testFourSumCount() {
        int[] nums1 = { 1, 2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }


    public int fourSumCount(int[] nums1,int[] nums2,int[] nums3,int[] nums4) {
        int res = 0;
        Map<Integer,Integer> numMap = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                numMap.put(sum,numMap.getOrDefault(sum,0) + 1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                res += numMap.getOrDefault(0-i-j,0);
            }
        }

        return res;
    }
}
package com.course.code.Hash;

import java.util.*;

/**
 * 349 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集
 * 示例 nums1 = [1,2,2,1] nums2 = [2,2] 输出[2]
 */
public class Intersection {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersectionHashSet(nums1, nums2)));

        System.out.println(Arrays.toString(intersectionHashArray(nums1,nums2)));

    }

    /**
     * 使用hashSet
     */

    public static int[] intersectionHashSet(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums1 == null || nums2.length == 0 || nums2 == null) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> resSet = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                resSet.add(nums2[i]);
            }
        }

        //将结果转为数组输出
        return resSet.stream().mapToInt(s -> s).toArray();

    }

    /**
     * 使用hash数组
     */
    public static int[] intersectionHashArray(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1002];
        int[] hash2 = new int[1002];
        for(int i : nums1)
            hash1[i]++;
        for(int i : nums2)
            hash2[i]++;
        List<Integer> resList = new ArrayList<>();
        for(int i = 0; i < 1002; i++)
            if(hash1[i] > 0 && hash2[i] > 0)
                resList.add(i);
        int index = 0;
        int res[] = new int[resList.size()];
        for(int i : resList)
            res[index++] = i;
        return res;
    }

}

package com.Leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 */


public class Ques_1 {

    public static void main(String[] args) {
        int[] nums = {3,1,1,4,5,9};
        int target = 9;
//        int[] twoedSum = twoSum(nums, target);
//        System.out.println(Arrays.toString(twoedSum));

        int[] twoedSum1 = forceTwoSum(nums,9);
        System.out.println(Arrays.toString(twoedSum1));


    }


    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //新建一个Map,key存放遍历出现过的值，value存放出现的索引
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0;i<nums.length;i++){
            int temp = target - nums[i];
            //遍历数组，如果9-nums[i]数组的值在Map中没存在过，就添加到Map ，如果存在就给结果数组添加索引值
            if(map.containsKey(temp)){
                result[1] = i;
                result[0] = map.get(temp);
            }else {
                map.put(nums[i],i);
            }

        }
        return result;
    }


    //暴力循环
    public static int[] forceTwoSum(int[] nums, int target){
        int[] res = new int[2];
        for (int i=0;i < nums.length;i++){
            for (int j = i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }

    //爱茶山
    public static int[] aiTwoSUm(int[] nums, int target){
        Map<Integer, Integer> idx = new HashMap<>();//创建一个空字典
        for (int j = 0;;j++){
            int x = nums[j];
            //在左边找nums[i],满足nums[i] + x =target;
            if (idx.containsKey(target-x)){
                return new int[]{idx.get(target-x),j};//返回两个数的下标
            }

            idx.put(x,j);
        }


    }


}

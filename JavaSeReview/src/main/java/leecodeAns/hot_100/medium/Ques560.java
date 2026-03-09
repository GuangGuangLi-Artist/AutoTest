package leecodeAns.hot_100.medium;

import java.util.HashMap;

/**
 * 560 和为K的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 */
public class Ques560 {


    public static void main(String[] args) {
        Ques560 ques560 = new Ques560();
        int[] nums = {4, 1, 2, 3, 0, 6, 2, 4};
        int subarraySum = ques560.subarraySum(nums, 6);
        System.out.println(subarraySum);


    }


    public int subarraySum(int[] nums, int k) {
        //count用于记录符合条件的子数组个数
        int count = 0;
        //preSum用于记录当前遍历到的累加和
        int preSum = 0;

        //Map的key:前缀和的值，Value:该前缀和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();

        //[非常重要] 初始化，前缀和为0默认出现过1次
        // 应对那种开头(索引0)加到当前位置正好等于K的情况
        //{4,1,2,3,0,6,2,4}
        map.put(0, 1);
        for (int num : nums) {
            //1. 累加当前数值
            preSum += num;

            //2.检查map中是否存在（preSum - k）
            //preSum - (preSum - k) = k
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }

            //3. 将当前的前缀和存入 map，如果已存在则次数 +1
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);


        }


        return count;

    }
}

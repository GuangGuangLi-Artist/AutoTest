package leecodeAns.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 。如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。返回好数对的数目。
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 */
public class Ques_1512 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,1};
        //int res = numIdenticalPairs(nums);
        int res = numIdenticalPairsMap(nums);
        System.out.println(res);
    }




    public static int numIdenticalPairs(int[] nums) {
        int ans = 0;
        int[] cnt = new int[10];
        //nums=[1,1,2,1]：
        for(int x: nums){
            //cnt[x] 表示之前遍历过的X的个数，加到ans
            //如果先执行cnt[x]++,再执行ant += cnt[x],就把i=j这种情况也统计进来了，算出的结果会偏大
            ans += cnt[x];
            cnt[x]++;

        }

        return ans;

    }

    public static int numIdenticalPairsMap(int[] nums) {
        int ans = 0;
        //Map存放数字出现的次数，健存放数字，value存放数字出现的次数
        Map<Integer, Integer> cnt = new HashMap();
        for (int x : nums) {
            int c = cnt.getOrDefault(x, 0);
            ans += c;
            cnt.put(x, c + 1);
        }
        return ans;

    }


}

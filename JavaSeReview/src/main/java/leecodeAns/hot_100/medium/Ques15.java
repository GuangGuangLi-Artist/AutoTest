package leecodeAns.hot_100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15 三数之和
 *
 *  给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 *  输入：nums = [-1,0,1,2,-1,-4]
 *  输出：[[-1,-1,2],[-1,0,1]]
 *  解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 */

public class Ques15 {
    public static void main(String[] args) {

        Ques15 ques15 = new Ques15();
        int [] nums = {-1,0,1,2,-1,-4};
        //List<List<Integer>> lists = ques15.threeSum(nums);
        List<List<Integer>> lists = ques15.threeSum1(nums);
        System.out.println(lists);

    }

    /**
     *
     * @param nums
     * @return
     * 为方便双指针以及跳过相同元素，先把 nums 排序。 [-1,0,1,2,-1,-4] >[-4,-1,-1,0,1,2]
     */
    public List<List<Integer>> threeSum(int[] nums) {

        //先把数组排序
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0;i< n -2; i++ ){
            int x = nums[i];
            if(i > 0 && x == nums[i-1]){
                continue;// 跳过重复数字
            }
            if(x + nums[i+1] + nums[i+2] > 0){
                break;
            }
            if(x + nums[n-2] + nums[n-1] < 0) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int s = x + nums[j] + nums[k];
                if(s > 0) {
                    k--;
                }else if(s < 0) {
                    j++;
                }else {
                    ans.add(List.of(x,nums[j],nums[k]));
                    for (j++;j<k && nums[j] == nums[j-1];j++);
                    for (k--;k>j && nums[k] == nums[k+1];k--);
                }
            }
        }
        return ans;


    }

    public List<List<Integer>> threeSum1(int[] nums) {
        //[-4,-1,-1,0,1,2]
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        //找出a + b + c = 0
        for (int i = 0;i<nums.length;i++){ //i = 2
            if(nums[i] > 0){// 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
                return res;
            }

            if(i > 0 && nums[i] == nums[i-1]){// 去重a
                continue;
            }

            int left = i+1;
            int right = nums.length -1;
            while (right>left){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum >0) {
                    right--;
                }else if(sum < 0){
                    left++;
                }else {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right>left && nums[right] == nums[right-1]) right--;
                    while (right > left && nums[left] == nums[left+1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return res;
    }


}

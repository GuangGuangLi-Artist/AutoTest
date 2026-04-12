package codesuixiang.hash;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 第15题. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意： 答案中不可以包含重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class Lee_15 {

    @Test
    public void testthreeSum(){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(Arrays.toString(lists.toArray()));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 如果第一个元素大于零，不可能凑成三元组
            if (nums[i] > 0) {
                return res;
            }

            //三元组元素a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                //三元组元素b去重
                if(j > i + 2 && nums[j] == nums[j -1] && nums[j - 1] == nums[j - 2]){
                    continue;
                }

                int c = -nums[i] - nums[j];
                if (set.contains(c)) {
                    res.add(Arrays.asList(nums[i], nums[j], c));
                    set.remove(c);// 三元组元素c去重
                }else {
                    set.add(nums[j]);
                }
            }
        }

        return res;


    }
}

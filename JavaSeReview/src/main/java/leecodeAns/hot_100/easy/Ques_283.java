package leecodeAns.hot_100.easy;

import java.util.Arrays;

/**
 * 283 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Ques_283 {
    public static void main(String[] args) {
        Ques_283 q = new Ques_283();
        int[] nums = {0,1,0,3,12};
        q.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

     }


    public void moveZeroes(int[] nums) {

        /**
         * 核心思路
         *  把 0 视作空位。我们要把所有非零元素都移到数组左边的空位上，并保证非零元素的顺序不变。
         *  为了保证非零元素的顺序不变，我们需要维护最左边的空位的位置（下标）。
         */
        int i0 = 0;//维护另一个下标 i0 i0指向最左边的空位
        for (int i =0;i<nums.length;i++) {
             if(nums[i] != 0) {//从左到右遍历 nums[i]。
                //交换nums[i] 和nums[i0]
                int temp = nums[i];
                nums[i] = nums[i0];
                nums[i0] = temp;
                i0++;//交换后把i0和i都加1
             }
        }

    }
}

package leecodeAns.hot_100.easy;


/**
 * 35 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 */
public class Ques35 {

    public static void main(String[] args) {
        Ques35 ques35 = new Ques35();
        int[] nums = {1,2,3,5,6,7};
        int target = 4;
        int insert = ques35.searchInsert(nums, target);
        System.out.println(insert);
        System.out.println(3/2);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left<=right) {
            //循环不变量
            // nums[left-1] < target
            // nums[right+1] >= target
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return left;

    }
}

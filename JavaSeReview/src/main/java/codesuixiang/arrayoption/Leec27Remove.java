package codesuixiang.arrayoption;

public class Leec27Remove {

    public static void main(String[] args) {

        int[] nums = {0,1,2,3,3,0,4,2};
        int val = 2;
        int element = removeElement(nums, val);
        System.out.println(element);

    }

    public static int removeElement(int[] nums, int val) {
        // 快慢双指针 {0，1，2，3，3，0，4，2} 删除2
        /**
         * 快慢双指针
         *  1.定义快指针 寻找新数组的元素 ，新数组就是不含有目标元素的数组
         *  2.定义慢指针，指向更新 新数组下标的位置
         */
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }


        return slow;
    }
}

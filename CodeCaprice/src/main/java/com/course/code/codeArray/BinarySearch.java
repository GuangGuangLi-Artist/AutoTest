package com.course.code.codeArray;

/**
 * 二分查找
 * 704 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        int resClose = binarySearchClose(nums,target);
        System.out.println(resClose);

        System.out.println("第二种方法");

        int resOpen = binarySearchOpen(nums,target);
        System.out.println(resOpen);



    }

    /**
     * 1 前提
     *      - 数组有序
     *      - 数组无重复元素
     * 2 注意点
     *      - 循环不变量原则
     */

    // 左闭右闭
    public  static  int binarySearchClose(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;// 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) {// 当left==right，区间[left, right]依然有效，所以用 <=
            int middle = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
            if(nums[middle] > target) {
                right = middle - 1;// target 在左区间，所以[left, middle - 1]
            }else if (nums[middle] < target) {
                left = middle + 1;// target 在右区间，所以[middle + 1, right]
            }else {
                return middle;// 数组中找到目标值，直接返回下标
            }
        }
        return -1;// 未找到目标值
    }

    // 左闭右开
    public static int binarySearchOpen(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 定义target在左闭右开的区间里，即：[left, right)
        while (left < right) { // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
            int middle = left + ((right - left) >> 1);
            if(nums[middle] < target) {
                left = middle + 1; // target 在右区间，在[middle + 1, right)中
            }else if(nums[middle] > target) {
                right = middle; // target 在左区间，在[left, middle)中
            }else {
                return middle; // 数组中找到目标值，直接返回下标
            }

        }

        //未找到目标值
        return -1;
    }

}






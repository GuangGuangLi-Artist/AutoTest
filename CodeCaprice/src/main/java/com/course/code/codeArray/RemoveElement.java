package com.course.code.codeArray;

/**
 * 27 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public static void main(String[] args) {

        /**
         * 注意点：
         *     要知道数组的元素在内存地址中是连续的，不能单独删除数组中的某个元素，只能覆盖。
         *
         */
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
//        int resForce = removeElementForce(nums,val);
//        System.out.println(resForce);
//        System.out.println("第二种解法");
//        int resDoublePoint = removeElementDoublePoint(nums,val);
        System.out.println("第三种解法");
        System.out.println(removeElementOppositeDoublePoint(nums,val));



    }

    // 暴力解法 两层for循环，一个for循环遍历数组元素 ，第二个for循环更新数组。
    public static  int removeElementForce(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if(nums[i] == val) { // 发现需要移除的元素，就将数组集体向前移动一位
                for (int j = i + 1; j < size; j++) {
                    nums[j-1] = nums[j];
                }
                i--; // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                size--; // 此时数组的大小-1
            }
        }
        return  size;
    }

    /**
     * 双指针法（快慢指针法） 通过一个快指针个慢指针在一个for循环下完成两个for循环的工作
     *
     *  定义快慢指针
     *      快指针：寻找新数组的元素，新数组就是不含有目标元素的数组
     *      慢指针：指向更新 新数组下标的位置
     */
    public static int removeElementDoublePoint(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if(val != nums[fastIndex]) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;

            }
        }
        return slowIndex;
    }

    /**
     * 相向双指针方法，基于元素顺序可以改变的题目描述改变了元素相对位置，确保了移动最少元素
     */
    public static int removeElementOppositeDoublePoint(int[] nums, int val) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            //找左边等于val的值
            while (leftIndex <= rightIndex && nums[leftIndex] != val ) {
                ++leftIndex;
            }
            //找右边等于value的值
            while (leftIndex <= rightIndex && nums[rightIndex] == val) {
                --rightIndex;
            }
            //将右边等于val的元素覆盖左边不等于val的元素
            if(leftIndex < rightIndex) {
                nums[leftIndex++] = nums[rightIndex--];
            }
        }
        return leftIndex; // leftIndex一定指向了最终数组末尾的下一个元素
    }
}

package codesuixiang.arrayoption;


/**
 * 209 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *     输入：s = 7, nums = [2,3,1,2,4,3]
 *     输出：2
 *     解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 */
public class Lee_209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;

        int length = getArrLength(nums, s);
        System.out.println(length);

    }


    //滑动窗口
    //窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
    //窗口的起始位置如何移动：如果当前窗口的值大于等于s了，窗口就要向前移动了（也就是该缩小了）
    //窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引。
    public static int getArrLength(int[] arr,int s) {
        int left = 0;// 滑动窗口起始位置
        int sum = 0;// 滑动窗口数值之和
        int result = Integer.MAX_VALUE;
        int subLength = 0;//滑动窗口的长度
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum >= s) {
                subLength = right - left + 1;// 取子序列的长度
                result = Math.min(result,subLength);
                sum -= arr[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

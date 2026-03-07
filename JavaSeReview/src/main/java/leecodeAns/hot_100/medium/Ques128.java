package leecodeAns.hot_100.medium;


import java.util.HashSet;
import java.util.Set;

/**
 * 128 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 */
public class Ques128 {
    public static void main(String[] args) {

        int [] nums = {100,4,200,1,3,2};
        Ques128 ques128 = new Ques128();
        int x = ques128.longestConsecutive(nums);
        System.out.println(x);

    }


    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int i : nums) {
            st.add(i);
        }

        int ans = 0;

        for (int x: st) {
            if(st.contains(x-1)) {// 如果 x 不是序列的起点，直接跳过 [100,4,200,1,3,2]
                continue;//是指如果x-1在set中存在，那就外层for循环在本层此处停止，代码不往下执行，重新遍历下一个元素
            }

            //x 是序列的起点
            int y = x + 1;
            while (st.contains(y)){
                y++;
            }

            //循环结束后，y-1 是最后一个在哈希集合中的数
            ans = Math.max(ans,y-x);
        }



        return ans;

    }

}

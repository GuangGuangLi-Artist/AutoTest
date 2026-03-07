package leecodeAns.hot_100.medium;

/**
 * 1456 定长子串中元音的最大数目
 *
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 */
public class Ques1456    {

    public static void main(String[] args) {
        Ques1456 ques1456 = new Ques1456();
        String s = "abciiidef";
        int k = 3;
         int vowels = ques1456.maxVowels(s, k);
        System.out.println(vowels);
    }


    /**
     *
     * @param s
     * @param k
     * @return
     *
     * 定长滑窗套路
     * 窗口右端点在i时，由于窗口长度为k,所以窗口左端点为i-k+1
     * 三步： 入>更新>出
     * 1.入，下标为 i 的元素进入窗口，更新相关统计量。如果窗口左端点 i−k+1<0，则尚未形成第一个窗口，重复第一步。
     * 2.更新：更新答案。一般是更新最大值/最小值。
     * 3.出：下标为 i−k+1 的元素离开窗口，更新相关统计量，为下一个循环做准备
     */
    public int maxVowels(String s, int k) {

        char[] chars = s.toCharArray();
        int ans = 0;
        int vowel = 0;
        for (int i =0;i<s.length();i++) {// 枚举窗口右端点 i
            // 1. 右端点进入窗口  "abciiidef"
            if(chars[i] == 'a' || chars[i] == 'o' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'u') {
                vowel++;
            }

            int left = i - k + 1;// 窗口左端点
            if(left < 0) {
                continue; // 窗口大小不足 k，尚未形成第一个窗口
            }

            //2. 更新答案
            ans = Math.max(ans,vowel);

            // 3. 左端点离开窗口，为下一个循环做准备
            char out = chars[left];
            if(out == 'a' || out == 'o' || out == 'e' || out == 'i' || out == 'u') {
                vowel--;
            }

        }

        return ans;

    }
}

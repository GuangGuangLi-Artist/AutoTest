package leecodeAns.hot_100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class Ques438 {

    public static void main(String[] args) {

        Ques438 ques438 = new Ques438();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = ques438.findAnagrams(s, p);
        System.out.println(anagrams);

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        //如果 s 比 p 还短，不可能存在异位词
        if(sLen < pLen) return ans;

        // 用两个数组记录字符出现的次数 (a-z 对应 0-25)
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        //s = "cbaebabacd", p = "abc"

        // 1. 初始化：统计 p 的字符频率，以及 s 的第一个窗口频率
        for (int i=0;i<pLen;i++){
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;

        }

        // 2. 如果初始化后的第一个窗口就匹配，记录下标 0
        if(Arrays.equals(pCount,sCount)) {
            ans.add(0);
        }
        //3. 开始滑动窗口  窗口右边界从 pLen 开始移动
        for (int i = pLen;i<sLen;i++){
            // 进一个字符 (右边界移动)
            sCount[s.charAt(i) - 'a']++;
            // 出一个字符 (左边界移动，索引是 i - pLen)
            sCount[s.charAt(i-pLen) - 'a']--;

            // 4. 比较两个数组是否完全一致
            // Arrays.equals 会比较数组长度和每个元素的值
            if(Arrays.equals(pCount,sCount)) {
                ans.add(i - pLen + 1);
            }

        }
        return ans;

    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        // 统计 p 的每种字母的出现次数
        int[] cntP = new int[26];
        for (char c: p.toCharArray()) {
            cntP[c-'a']++;
        }

        //统计 s 的长为 p.length() 的子串 t 的每种字母的出现次数
        int[] cntS = new int[26];
        for (int right=0;right<s.length();right++) {

            cntS[s.charAt(right) - 'a']++;// 右端点字母进入窗口
            int left = right - p.length() + 1;
            if (left < right){
                continue;
            }

            if(Arrays.equals(cntS,cntP)){// t 和 p 的每种字母的出现次数都相同
                ans.add(left);
            }

            cntS[s.charAt(left) -'a']--;// 左端点字母离开窗口

        }
        return ans;

    }
}

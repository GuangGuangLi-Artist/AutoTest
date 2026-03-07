package leecodeAns.hot_100.medium;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长字串
 */
public class Ques3 {

    public static void main(String[] args) {
        Ques3 ques3 = new Ques3();
        //int pwwkew = ques3.lengthOfLongestSubstring("pwwkew");
        int pwwkew = ques3.lengthOfLongestSubstring1("pwwkew");
        System.out.println(pwwkew);

    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();//pwwkew
        int n = chars.length;
        int ans = 0;
        int left = 0;
        int[] cnt = new int[128];
        for (int right=0;right < n; right++) {
            char c = chars[right];
            cnt[c]++;
            while (cnt[c] > 1) {
                cnt[chars[left]]--;
                left++;
            }
            ans = Math.max(ans,right - left + 1);
        }
        return ans;


    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) return 0;

        // HashMap 用来记录字符最后出现的位置
        // Key: 字符, Value: 字符对应的下标
        HashMap<Character,Integer> map = new HashMap<>();
        int maxlen = 0;// 用于记录最长长度
        int left = 0;// 滑动窗口的左边界

        // right 代表滑动窗口的右边界，不断向右移动
        for (int right=0;right < s.length();right++) {
            char currentChar = s.charAt(right);

            // 如果发现当前字符已经在 map 中了
            if(map.containsKey(currentChar)){
                /**
                 * 关键点：左边界要跳到重复字符上一次出现位置的下一个地方。
                 * 为什么要用 Math.max？
                 * 因为重复的字符可能在当前 left 的左边（已经被排除在窗口外了），
                 * 我们不能让 left 往回跳。
                 */
                left = Math.max(left,map.get(currentChar) + 1);
            }
            // 更新（或插入）当前字符的最新下标
            map.put(currentChar,right);

            // 计算当前窗口的长度：右边界 - 左边界 + 1
            // 比如 left=0, right=2，窗口里有 3 个字符 (0, 1, 2)
            maxlen = Math.max(maxlen,right-left + 1);
        }

        return maxlen;
    }


}

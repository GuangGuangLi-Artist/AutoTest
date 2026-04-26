package codesuixiang.strOpe;

import org.testng.annotations.Test;

/**
 * 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 */
public class Lee_459 {


    @Test
    public void testIsDuplicate(){
        String s = "abab";
        System.out.println(isDuplicate(s));
    }

    public boolean isDuplicate(String s) {
        // 将字符串 s 与自身拼接
        String doubles = s + s;

        //去掉首尾字符
        String trimed = doubles.substring(1,doubles.length() -1);

        return trimed.contains(s);
    }


    /**
     * 充分条件：如果字符串s是由重复子串组成的，那么它的最长相等前后缀不包含的子串一定是s的最小重复子串。
     * 必要条件：如果字符串s的最长相等前后缀不包含的子串是s的最小重复子串，那么s必然是由重复子串组成的。
     * 推得：当字符串s的长度可以被其最长相等前后缀不包含的子串的长度整除时，不包含的子串就是s的最小重复子串。
     * @param s
     * @return
     */
    public boolean isDuplicate1(String s){
        int n = s.length();

        // Step 1.构建KMP算法的前缀表
        int[] next = new int[n];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i< n; i++){
            while (j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j -1];
            }
            if(s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        if(next[n -1 ] > 0 && n % (n - next[n -1]) == 0) {// 当字符串s的长度可以被其最长相等前后缀不包含的子串的长度整除时
            return true;
        }else {
            return false;// 不包含的子串就是s的最小重复子串
        }

    }
}

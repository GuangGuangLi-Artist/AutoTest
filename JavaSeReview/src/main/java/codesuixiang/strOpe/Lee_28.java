package codesuixiang.strOpe;


import org.testng.annotations.Test;

/**
 * 28 实现 strStr()
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 * 示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 */
public class Lee_28 {


    /**
     * 暴力循环
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();//hello
        int needleLen = needle.length();//ll
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i < haystackLen - needleLen + 1; i++) {
            // 初始化匹配的指针
            int a = i;
            int b = 0;
            // 循环检查 needle 是否在当前位置开始匹配
            while (b < needleLen && haystackChars[a] == needleChars[b]) {
                // 如果当前字符匹配，则移动指针
                a++;
                b++;
            }

            //如果 b 等于 needleLen，说明 needle 已经完全匹配，返回当前位置 i
            if (b == needleLen) {
                return i;
            }
        }
        return -1;
    }


    /**
     *
     */

    @Test(description = "KMP算法解决字符串匹配")
    public void testStrStrByKmp(){
        String haystack = "aabaabaafa";
        String needle = "aabaaf";
        System.out.println(strStrByKmp(haystack,needle));
    }

    public int strStrByKmp(String haystack, String needle) {
        int needlelength = needle.length();
        int[] next = new int[needlelength];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)){
                j = next[j - 1];
            }

            if(needle.charAt(j) == haystack.charAt(i)){
                j++;
            }
            if(j == needle.length()){
                return i - needlelength + 1;
            }
        }
        return  -1;

    }

    private void getNext(int[] next, String needle) {
        //构建next数组分三步走
        //第一步  初始化
        int j = 0;//指向前缀末尾
        next[0] = 0;
        //i 指向后缀末尾
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) { //处理不相等
                j = next[j - 1]; //字符不相等
            }

            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

    }

}

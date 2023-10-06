package stringOption;


/**
 *
 * 28 实现strStr()
 *     实现 strStr() 函数。
 *     给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *     示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 *     示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 *
 *  KMP的经典思想就是:当出现字符串不匹配时，可以记录一部分之前已经匹配的文本内容，利用这些信息避免从头再去做匹配。
 *  要在文本串：aabaabaafa 中查找是否出现过一个模式串：aabaaf。
 *  那么什么是前缀表：记录下标i之前（包括i）的字符串中，有多大长度的相同前缀后缀。
 *  最长公共前后缀
 *      文章中字符串的前缀是指不包含最后一个字符的所有以第一个字符开头的连续子串。后缀是指不包含第一个字符的所有以最后一个字符结尾的连续子串。
 *      因为前缀表要求的就是相同前后缀的长度。
 *
 * 构造next数组其实就是计算模式串s，前缀表的过程。 主要有如下三步：
 *     初始化
 *     处理前后缀不相同的情况
 *     处理前后缀相同的情况
 *
 */
public class KmpSolution {
    public static void main(String[] args) {
        String  haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack,needle));
    }




    //前缀表不减1

    public static int strStr(String hayStack,String needle) {
        if(needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next,needle);

        int j = 0;
        for (int i = 0; i < hayStack.length(); i++) {
            while (j > 0 && needle.charAt(j) != hayStack.charAt(i)) j = next[j - 1];
            if(needle.charAt(j) == hayStack.charAt(i))  j++;
            if(j == needle.length()) return  i - needle.length() + 1;

        }
        return -1;
    }


    //构造next数组
    private static  void getNext(int[] next,String s) {
        int j = 0;//前缀末尾位置
        // i 后缀末尾位置
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) j = next[j - 1];  // 前后缀不相同了 向前回退
            if(s.charAt(j) == s.charAt(i)) j++; //找到相同的前后缀
            next[i] = j; // 将j（前缀的长度）赋给next[i]
        }
    }
}

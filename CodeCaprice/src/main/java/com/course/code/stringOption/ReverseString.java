package com.course.code.stringOption;


import org.testng.annotations.Test;

/**
 * 344 反转字符串
 *     编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *     不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *     示例 1：
 *         输入：["h","e","l","l","o"]
 *         输出：["o","l","l","e","h"]
 */
public class ReverseString {

    @Test
    public void testReverseString() {
        char[] chars = {'h','e','l','l','o'};
        reverseString(chars);
        String s = new String(chars);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}

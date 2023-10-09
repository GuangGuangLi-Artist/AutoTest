package com.course.code.stringOption;


import org.testng.annotations.Test;

/**
 * 541 反转字符串II
 *     给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
 *     如果剩余字符少于 k 个，则将剩余字符全部反转。
 *     如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *     示例:
 *     输入: s = "abcdefg", k = 2
 *     输出: "bacdfeg"
 */
public class ReverseStr {

    @Test
    public void testReverseStr(){
        String s = "abcdefg";
        int k = 2;
        String str = reverseStr(s, k);
        System.out.println(str);

    }

    private String reverseStr(String s, int k) {

        //题目的意思其实概括为 每隔2k个反转前k个，尾数不够k个时候全部反转
        char [] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i += 2 * k) {
            int start = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(chs.length - 1,start + k - 1);
            while (start < end) {
                //使用异或运算进行反转
                chs[start] ^= chs[end];
                chs[end] ^= chs[start];
                chs[start] ^= chs[end];
                start++;
                end--;

            }
        }
        return new String(chs);


    }
}

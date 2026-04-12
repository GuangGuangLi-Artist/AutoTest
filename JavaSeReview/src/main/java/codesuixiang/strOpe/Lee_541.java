package codesuixiang.strOpe;

import org.testng.annotations.Test;

/**
 * 541. 反转字符串II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class Lee_541 {

    @Test
    public void testRever(){
        String ss = "abcdefg";
        int k = 2;
        System.out.println(reverSre(ss,k));
    }

    public String reverSre(String str,int k){
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i += 2 * k){
            int start = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);

            while (start < end){
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}

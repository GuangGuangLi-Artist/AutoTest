package leecodeAns.hot_100.easy;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Ques_344 {
    /**
     * 344,反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     */

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        //reverseString(chars);
        reverseString2(chars);
        System.out.println(Arrays.toString(chars));
    }


    //使用库函数反转
    public static void reverseString2(char[] s) {
        StringBuilder sb = new StringBuilder(new String(s));
        sb.reverse();
        System.out.println(sb);

        //将反转后的字符串重新填回原数组
        for (int i = 0; i < s.length; i++) {
            s[i] = sb.charAt(i);
        }

    }


    //双指针法
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }

}

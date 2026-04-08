package codesuixiang.hash;

import org.testng.annotations.Test;

/**
 * 242.有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 *示例 2: 输入: s = "rat", t = "car" 输出: false
 */
public class Lee_242 {


    @Test
    public void testIsAngaram(){
        String s1 = "anagram";
        String t = "nagaram";

        boolean angaram = isAngaram(s1, t);
        System.out.println(angaram);

        System.out.println("------------------");
        String s2 = "rat";
        String t2 = "car";


        boolean bb = isAngaram(s2, t2);
        System.out.println(bb);
    }


    public boolean isAngaram(String s1,String s2){
        int[] chars1 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            //将s1出现过的字符都计数放在chars1
            chars1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            chars1[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

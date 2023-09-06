package com.course.code.Hash;


/**
 * 242 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 * 注意： 若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class IsAnagram {

    public static void main(String[] args) {

        boolean anagram = isAnagram("aee", "eae");
        System.out.println(anagram);

    }

    public static boolean isAnagram (String s,String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;// 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count:record) {
            if(count != 0) {
                return false;// record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
            }
        }
        return true;// record数组所有元素都为零0，说明字符串s和t是字母异位词
    }
}

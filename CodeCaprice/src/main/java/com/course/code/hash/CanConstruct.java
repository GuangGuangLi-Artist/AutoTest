package com.course.code.hash;


/**
 * 383 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 *
 * 你可以假设两个字符串均只含有小写字母。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class CanConstruct {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("ransom", "magazine"));
    }

    /**
     * 哈希解法
     * 因为题目说只有小写字母，那可以采用空间换取时间的哈希策略，用一个长度为26的数组来记录magazine里字母出现的次数。
     * 然后再用ransomNote去验证这个数组是否包含了ransomNote所需要的所有字母。
     *
     */
    public static boolean canConstruct(String ransomNode,String magazine) {

        //shortCut
        if(magazine.length() < ransomNode.length()) {
            return false;
        }
        int [] record = new int[26];
        for (char c : magazine.toCharArray()) {
            record[c - 'a']+=1;
        }

        for (char c:ransomNode.toCharArray()) {
            record[c - 'a'] -=1;
        }
        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for (int i: record) {
            if(i < 0) {
                return false;
            }
        }

        return true;
    }

}

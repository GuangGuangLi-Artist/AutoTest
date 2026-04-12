package codesuixiang.hash;

/**
 * 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * 你可以假设两个字符串均只含有小写字母。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 *
 */
public class Lee_383 {

    public static void main(String[] args) {

        String ransom = "abc";
        String magazine = "aabbcc";
        System.out.println(canConstruct(ransom, magazine));


    }

    public static boolean canConstruct(String ransom, String magazine) {

        //shortcut
        if(ransom.length() > magazine.length()) return false;

        //定义一个哈希映射数组
        int [] record = new int[26];

        // 遍历
        for (int i : magazine.toCharArray()) {
            record[i - 'a'] += 1;
        }


        for (int c : ransom.toCharArray()) {
            record[c - 'a'] -= 1;
        }

        //如果数组中存在负数，说明ransomNote字符串中存在magazine中没有的字符
        for (int i : record) {
            if (i < 0) {
                return false;
            }
        }

        return true;

    }


}

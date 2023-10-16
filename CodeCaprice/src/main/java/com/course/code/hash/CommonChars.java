package com.course.code.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002 查找常用字符
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
 *  words = ["bella","label","roller"] 输出：["e","l","l"]
 *  words = ["cool","lock","cook"] 输出：["c","o"]
 *
 *
 *      整体思路就是统计出搜索字符串里26个字符的出现的频率，然后取每个字符频率最小值，最后转成输出格式就可以了
 *      先统计第一个字符串所有字符出现的次数
 *      接下来，把其他字符串里字符的出现次数也统计出来一次放在hashOtherStr中
 *      然后hash 和 hashOtherStr 取最小值，这是本题关键所在，此时取最小值，就是 一个字符在所有字符串里出现的最小次数了
 *      此时hash里统计着字符在所有字符串里出现的最小次数，那么把hash转成题目要求的输出格式就可以了
 */
public class CommonChars {
    public static void main(String[] args) {
        String[] strs = {"bella","label","roller"};
        List<String> tesRes = commonChars(strs);
        System.out.println(Arrays.toString(tesRes.toArray()));
        tesRes.forEach(System.out::print);

    }

    //["ll","ll","ll"] 输出：["l","l"]

    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if(A.length == 0) return result;

        int[] hash = new int[26]; //用来统计所有字符串哩字符出现得最小频率
        for (int i = 0; i < A[0].length(); i++) {//用第一个字符串给hash初始化
            hash[A[0].charAt(i) - 'a']++;

        }

        //统计除第一个字符串外字符出现得频率
        for (int i = 1; i < A.length; i++) {
            int [] hashOtherStr = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                hashOtherStr[A[i].charAt(j) - 'a']++;
            }

            //更新hash 保证hash里统计的26个字符里出现的最小次数
            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min(hash[k],hashOtherStr[k]);
            }

        }
        //将hash统计的字符次数 转成输出形式
        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0) {
                char c = (char) (i + 'a');
                result.add(String.valueOf(c));
                hash[i]--;
            }
        }
        return result;

    }
}

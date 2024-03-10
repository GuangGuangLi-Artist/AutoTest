package com.course.code.backTracing;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 17.电话号码的字母组合 https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0017.%E7%94%B5%E8%AF%9D%E5%8F%B7%E7%A0%81%E7%9A%84%E5%AD%97%E6%AF%8D%E7%BB%84%E5%90%88.md
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 *     输入："23"
 *     输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class PhoneNumber {

    List<String> res = new ArrayList<>();
    public List<String> letterCombineations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits,numString,0);
        return res;
    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuilder
    StringBuilder sb = new StringBuilder();
    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    private void backTracking(String digits, String[] numString, int num) {
        //遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            res.add(sb.toString());
            return;
        }

        //str 表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            backTracking(digits,numString,num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    @Test
    public void testPhone() {
        PhoneNumber phoneNumber = new PhoneNumber();
        List<String> list = phoneNumber.letterCombineations("23");
        System.out.println(StringUtils.join("",list.toString()));
    }
}

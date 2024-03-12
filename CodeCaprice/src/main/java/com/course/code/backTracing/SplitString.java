package com.course.code.backTracing;


import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *  131.分割回文串
 *      给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *      返回 s 所有可能的分割方案。
 *      示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 */
public class SplitString {
    List<List<String>> res = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return res;
    }

    private void backTracking(String s,int strartIndex) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (strartIndex >= s.length()) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = strartIndex; i < s.length(); i++) {
            //如果是回文子串，则记录
            if (isPalindrome(s,strartIndex,i)) {
                String str = s.substring(strartIndex,i+1);
                deque.addLast(str);
            }else {
                continue;
            }
            //起始位置后移，保证不重复
            backTracking(s,i+1);
            deque.removeLast();
        }

    }

    //判断是否是回文串
    private boolean isPalindrome(String s, int startIndex,int end) {
        for (int i = startIndex,j=end; i < j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

        }
        return true;
    }


    @Test
    public void testSpli() {

        SplitString sp = new SplitString();
        String s = "aab";
        List<List<String>> lists = sp.partition(s);
        System.out.println(StringUtils.join("",lists.toString()));
    }


}

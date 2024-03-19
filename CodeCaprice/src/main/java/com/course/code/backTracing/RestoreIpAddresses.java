package com.course.code.backTracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 93.复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 */
public class RestoreIpAddresses {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb,0,0);
        return result;
    }

    private void backtracking(StringBuilder s,int startIndex,int doCount) {
        if (doCount == 3) {
            if (isValid(s,startIndex,s.length() -1)) {
                result.add(s.toString());
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s,startIndex,i)) {
                s.insert(i+1,',');
                backtracking(s,i+2,doCount+1);
                s.deleteCharAt(i+1);
            }else {
                break;
            }
        }
    }

    private boolean isValid(StringBuilder s, int start, int end) {
        if (start > end) {
            return false;
        }

        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <=end ; i++) {
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            if (num > 255) {
                return false;
            }
        }

        return true;
    }
}

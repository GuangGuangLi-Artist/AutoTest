package com.course.code.commonFunction;

public class ReversStringTest {
    public static void main(String[] args) {
        String str = "abcdefg";
        int k = 3;
        System.out.println(reverseStr(str, k)); // 输出：cbafedg
    }

    /**
     * 反转字符串中每隔k个字符的子串（使用 substring 方法）
     * @param str 输入字符串
     * @param k 反转间隔
     * @return 处理后的字符串
     */
    public static String reverseStr(String str, int k) {
        if (k <= 0 || str == null || str.length() <= k) {
            return str; // 无效输入或无需反转时直接返回
        }

        StringBuilder result = new StringBuilder();
        int len = str.length();

        for (int i = 0; i < len; i += k) {
            // 计算当前子串的结束位置（不超过字符串长度）
            int end = i + k;
            if (end > len) {
                end = len;
            }
            // 截取子串并反转
            String sub = str.substring(i, end);
            StringBuffer sb = new StringBuffer(sub);
            result.append(sb.reverse()); // 反转子串并拼接到结果中
        }

        return result.toString();
    }
}

package com.course.code.commonFunction;

public class ReverseMethod {
    public static void main(String[] args) {
        String str = "abcdefg";
        int k = 3;


//        System.out.println(reverseStr(str, k)); //
        System.out.println(reverseStrMethod1(str, k));
    }


    public static String reverseStrMethod1(String str, int k) {
        if (str == null || str.length() <= k || k <= 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i+=k) {
            int end = i + k;
            if(end > str.length()) {
                end = str.length();
            }

            String strsub = str.substring(i, end);
            StringBuffer stringBuffer = new StringBuffer(strsub);
            sb.append(stringBuffer.reverse());
        }
        return sb.toString();
    }


    public static String reverseStr(String str, int k) {
        if (str == null || k <= 0 || str.length() <= k) {
            return str;
        }

        char[] chars = str.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length; i += k) {
            // 确定当前子串的结束索引
            int end = Math.min(i + k - 1, chars.length - 1);
            // 反转子数组 [i, end]
            reverse(chars, i, end);
            // 将反转后的子串追加到结果中
            result.append(chars, i, end - i + 1);
        }

        return result.toString();
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
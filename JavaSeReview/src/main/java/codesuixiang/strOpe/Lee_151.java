package codesuixiang.strOpe;

import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 151.翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 */
public class Lee_151 {

    @Test
    public void testRev(){
        String ss = "the sky is blue";
        System.out.println(revStr(ss));

        System.out.println("-------------------");

        System.out.println(revNews(ss));
    }


    //不推荐
    public String revStr(String ss) {
        String[] strings = ss.split(" ");
        String news = "";
        for (int i = strings.length - 1; i >= 0; i--) {
            if(i == 0){
                news += strings[i] + "";
            }else {
                news += strings[i] + " ";
            }

        }
        return news;

    }

    //推荐
    /**
     * 思路
     * 1.移除多余的空格
     * 2.字符串反转
     * 3.单词反转
     */


    public String revNews(String ss) {
        StringBuilder sb = removeSpace(ss);
        reverString(sb,0,sb.length() -1);

        reverseEachWord(sb);
        return sb.toString();

    }

    //移除多余的空格
    public StringBuilder removeSpace(String ss) {
        int statr = 0;
        int end = ss.length() - 1;
        while (ss.charAt(statr) == ' ') {
            statr++;
        }
        while (ss.charAt(end) == ' ') {
            statr--;
        }

        StringBuilder sb = new StringBuilder();
        while (statr <= end) {
            char c = ss.charAt(statr);
            if(c != ' ' || sb.charAt(sb.length()-1) != ' '){
                sb.append(c);
            }
            statr++;
        }
        return sb;
    }

    //字符串反转 反转字符串指定区间[start, end]的字符
    public void reverString(StringBuilder sb,int start,int end){

        while (start < end) {
            char c = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));//修改指定索引处的字符
            sb.setCharAt(end,c);
            start++;
            end--;
        }

    }

    //反转字符串指定区间[start, end]的字符
    public void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverString(sb,start,end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}

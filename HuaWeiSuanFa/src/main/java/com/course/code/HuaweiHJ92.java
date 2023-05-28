package com.course.code;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 在字符串中找出连续最长的数字串
 *
 *
 * 输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
 * 本题含有多组样例输入。
 *
 * 输入一个字符串。1<=len(字符串)<=200
 *
 * 输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不要输出空格）。
 *
 * 输入：
 * abcd12345ed125ss123058789
 * a8a72a6a5yy98y65ee1r2
 * 输出：
 * 123058789,9
 * 729865,2
 * 说明：
 * 样例一最长的数字子串为123058789，长度为9
 * 样例二最长的数字子串有72,98,65，长度都为2
 */
public class HuaweiHJ92 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            char[] chs = line.toCharArray();
            StringBuffer sb = new StringBuffer();
            int max = 0;
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < chs.length; i++) {
                if(chs[i] >= '0' && chs[i] <= '9'){
                    //如果字符是数字 那我就添加到创建好的sb中
                    sb.append(chs[i]);
                }else {
                    //如果不是数字 那我就将sb添加到list，并创建新的sb，""
                    list.add(sb.toString());
                    sb = new StringBuffer();
                }
            }

            //将最后循环结束的字符串添加到list
            list.add(sb.toString());

            for (String s: list){
                max = Math.max(max,s.length());
            }

            //查找是否有相同的长度的数字串
            for (String s2: list){
                if(s2.length() == max){
                    System.out.print(s2);
                }
            }
            System.out.print("," + max);
        }

    }
}

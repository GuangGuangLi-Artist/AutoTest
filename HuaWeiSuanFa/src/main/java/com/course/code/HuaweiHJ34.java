package com.course.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过代码解决。
 * Lily使用的图片使用字符"A"到"Z"、"a"到"z"、"0"到"9"表示。
 *输入：
 * 一行，一个字符串，字符串中的每个字符表示一张Lily使用的图片。
 * 输出：
 * Lily的所有图片按照从小到大的顺序输出
 *输入：Ihave1nose2hands10fingers
 * 输出：0112Iaadeeefghhinnnorsssv
 *
 */
public class HuaweiHJ34 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resource = scanner.nextLine();
        char[] chs = resource.toCharArray();

        List<Character> chsList  = new ArrayList<Character>();
        for (Character c: chs){
            chsList.add(c);
        }

        Collections.sort(chsList);

        StringBuffer sb = new StringBuffer();
        for (Character c: chsList){
            sb.append(c);
        }
        String res = new String(sb);
        System.out.println(res);


    }
}

package com.course.code;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 */

public class HuaWeiHJ26 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source =scanner.nextLine();
        System.out.println(sortString(source));
    }


    public static String sortString(String s){

        //定义字符列表
        List<Character> ch = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        char[] charArray = s.toCharArray();
        for (Character c: charArray){//遍历 是字符就添加到字符列表
            if(Character.isLetter(c)){
                ch.add(c);
            }
        }

        //将英文字母的顺序先排列好
        ch.sort(Comparator.comparingInt(Character::toLowerCase));

        //非英文字母直接添加
        for (int i = 0,j = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i))){
                sb.append(ch.get(j++));
            }else {
                sb.append(s.charAt(i));
            }
        }


        return sb.toString();

    }
}

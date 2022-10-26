package com.course.code;

import java.util.Scanner;

/**
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 *
 * 示例1
 * 输入：
 * abc
 * 输出：
 * abc00000
 * 复制
 */

public class HuaWeiSplitString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        split(line);


    }

    /**
     * 1.获取输入的字符串
     * 2.判断字符串长度，小于8,在后面补上0，达到8位，大于8，先以8位作为
     * 一段截取，再判断剩余字符串长度与8比较，如果小于8,照上述操作，大于8，先截取8位，再判断剩下的...
     * 如此循环操作。
     */

    public static void split(String s){
        while (s.length()>=8){
            System.out.println(s.substring(0,8));
            s = s.substring(8);//循环获取第8个字符后的字符串内容 直到字符串长度小于八位
        }
        if(s.length()<8 && s.length()>0){
            s+="00000000";
            System.out.println(s.substring(0,8));
        }
    }
}

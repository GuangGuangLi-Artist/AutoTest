package com.course.code;


import java.util.Scanner;

/**
 * 判断短字符串S中的所有字符是否在长字符串T中全部出现。
 * 请注意本题有多组样例输入。
 *
 * 输入描述：输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
 * 输出描述：如果短字符串的所有字符均在长字符串中出现过，则输出字符串"true"。否则输出字符串"false"。
 *
 * */
public class HuaweiHJ81 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String first = scanner.nextLine();
            String second = scanner.nextLine();

            System.out.println(getBoolean(first,second));
        }



    }

    public static  boolean getBoolean(String first,String second){

        boolean flag = false;
        if(second.contains(first)){
            flag = true;
        }
        return flag;
    }
}

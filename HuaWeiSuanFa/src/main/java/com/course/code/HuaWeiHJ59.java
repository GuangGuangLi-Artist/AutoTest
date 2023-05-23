package com.course.code;

import java.util.HashSet;
import java.util.Scanner;

public class HuaWeiHJ59 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();

        int count = 0;
        char[] chars = line1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if(chars[i] == chars[j]){
                    count++;
                }
            }

            if(count==1){//遍历整个字符串后count=1说明这个就是第一个出现的只有一次的字符
                System.out.println(chars[i]);
                break;
            }else {
                count = 0;// //否则重置计数位
            }

        }

        if(count == 0){//所有字符都遍历了，count为0说明没有只出现一次的字符
            System.out.println(-1);
        }
    }
}

package com.course.code;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static java.util.Collections.reverse;

/**
 * 将输入的字符串（字符串仅包含小写字母‘a’到‘z’），按照如下规则，循环转换后输出： a->b,b->c,…,y->z,z->a；若输入的字符串连续出现两个
 * 字母相同时，后一个字母需要连续转换 2 次。
 *
 * 例如： aa 转换为 bc， zz 转换为 ab；当连续相同字母超过两个时，第三个出现的字母按第一次出现算。
 */

public class HuaWeiStringConvert {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        ArrayList<String> al = new ArrayList<String>(Arrays.asList(strings));
    }


    @Test
    public void sortString(){
        System.out.println("test");
    }
}

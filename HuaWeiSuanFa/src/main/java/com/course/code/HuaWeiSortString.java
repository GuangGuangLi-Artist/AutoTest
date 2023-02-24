package com.course.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HuaWeiSortString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        ArrayList<String> strList = new ArrayList<>(num);
        while (num>0){
            strList.add(scanner.nextLine());
            num--;

        }

        Collections.sort(strList);

        for (String s: strList){
            System.out.println(s);
        }

    }
}

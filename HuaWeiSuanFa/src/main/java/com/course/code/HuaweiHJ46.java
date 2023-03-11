package com.course.code;

import java.util.Scanner;

public class HuaweiHJ46 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String res = scanner.nextLine();
            int x = Integer.parseInt(scanner.nextLine());

            String substring = res.substring(0, x);
            System.out.println(substring);
        }
    }
}

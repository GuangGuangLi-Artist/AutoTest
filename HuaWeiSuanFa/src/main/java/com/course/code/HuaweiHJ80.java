package com.course.code;


import java.util.*;

/**
 *描述
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 * 输出时相邻两数之间没有空格
 *
 * 输入描述：
 * 输入说明，按下列顺序输入：
 * 1 输入第一个数组的个数
 * 2 输入第一个数组的数值
 * 3 输入第二个数组的个数
 * 4 输入第二个数组的数值
 *
 *
 * 输入：
 * 3
 * 1 2 5
 * 4
 * -1 0 3 2
 *
 * 输出：-101235
 */
public class HuaweiHJ80 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int x = Integer.parseInt(scanner.nextLine());
            String firstStr = scanner.nextLine();
            String [] firstStrArr = firstStr.split(" ");

            int second = Integer.parseInt(scanner.nextLine());
            String secondStr = scanner.nextLine();
            String[] secondStrArr = secondStr.split(" ");

            Set<String> stringSet = new TreeSet<>();
            for (int i = 0; i < firstStrArr.length; i++) {
                stringSet.add(firstStrArr[i]);
            }

            for (int i = 0; i < secondStrArr.length; i++) {
                stringSet.add(secondStrArr[i]);
            }

            for (String s: stringSet){
                System.out.print(s);
            }


        }

    }


}

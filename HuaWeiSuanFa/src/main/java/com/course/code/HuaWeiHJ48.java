package com.course.code;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 从单向链表中删除指定值的节点.
 *
 * 输入一行，有以下4个部分：
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 *
 * 输出删除结点后的序列，每个数后都要加空格
 *
 * 输入：5 2 3 2 4 3 5 2 1 4 3
 *
 * 输出：2 5 4 1
 */
public class HuaWeiHJ48 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int total = scanner.nextInt();
            int head = scanner.nextInt();

            List<Integer> linkedlist = new ArrayList<>();

            linkedlist.add(head);

            for (int i = 0; i < total -1; i++) {
                int value = scanner.nextInt();
                int target = scanner.nextInt();
                linkedlist.add(linkedlist.indexOf(target) + 1,value);
            }

            int remove = scanner.nextInt();
            linkedlist.remove(linkedlist.indexOf(remove));
            for (int i:linkedlist) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        scanner.close();


    }
}

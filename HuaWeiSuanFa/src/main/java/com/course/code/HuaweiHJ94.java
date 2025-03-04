package com.course.code;

import java.util.Scanner;

/**
 * 请实现一个计票统计系统。你会收到很多投票，其中有合法的也有不合法的，请统计每个候选人得票的数量以及不合法的票数。
 *
 *
 * 第一行输入候选人的人数n，第二行输入n个候选人的名字（均为大写字母的字符串），第三行输入投票人的人数，第四行输入投票。
 * 按照输入的顺序，每行输出候选人的名字和得票数量（以" : "隔开，注：英文冒号左右两边都有一个空格！），最后一行输出不合法的票数，格式为"Invalid : "+不合法的票数。
 *
 * 输入：
 * 4
 * A B C D
 * 8
 * A D E CF A GG A B
 * 输出：
 * A : 3
 * B : 1
 * C : 0
 * D : 1
 * Invalid : 3
 * 说明：
 * E CF GG三张票是无效的，所以Invalid的数量是3.
 */

public class HuaweiHJ94 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int[] depiao = new int[num];
        String names = scanner.nextLine();
        int voteNum = Integer.parseInt(scanner.nextLine());
        String piaos = scanner.nextLine();

        int invalid = 0;
        String[] name = names.split(" ");
        String[] piao = piaos.split(" ");
        for (int i = 0; i < piao.length; i++) {
            for (int j = 0; j < name.length; j++) {
                if(piao[i].equals(name[j])){
                    depiao[j]++;
                    break;
                }
                if(j == name.length -1){
                    invalid++;
                }
            }
        }
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i] + " : " + depiao[i]);

        }
        System.out.println("Invalid : "  + invalid);



    }
}

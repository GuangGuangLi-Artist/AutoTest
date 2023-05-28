package com.course.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 配置文件恢复
 *
 * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配（注：需从首字母开始进行匹配）：
 *
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但匹配命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
 *
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配，继续匹配第二关键字，如果仍不唯一，匹配失败。
 * 例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unknown command。
 * 例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配，继续匹配第二关键字，如果唯一，匹配成功。例如输入：bo a，确定是命令board add，匹配成功。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：b addr，无法匹配到相应的命令，所以执行结果为：unknow command。
 * 6、若匹配失败，打印“unknown command”
 *
 * 注意：有多组输入。
 *
 * 输入描述：
 * 多行字符串，每行字符串一条命令
 *
 * 输出描述：
 * 执行结果，每条命令输出一行
 */

public class HuaweiHJ66 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s ;
        while ((s = scanner.nextLine()) != null){
            revover(s);
        }
    }

    private static void revover(String s) {
        String [] origin = {"reset","reset board","board add","board delete","reboot backplane","backplane abort","he he"};
        Map<String,String>  map = new HashMap<>();
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("board delete", "no board at all");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        map.put("he he", "unknown command");

        String[] input = s.split(" ");
        int count = 0;
        String key = "";
        if(input.length == 1){
            String cmd = origin[0].substring(0,input[0].length());
            if(cmd.equals(input[0])){
                key = origin[0];
                count++;
            }else {
                key = origin[6];

            }
        }else {
            if(input.length > 2){
                key = origin[6];
            }else {
                String input1 = input[0],input2 = input[1];
                for (int i = 1; i < origin.length; i++) {
                    String[] two = origin[i].split(" ");
                    if(input1.length() > two[0].length() || input2.length() > two[1].length()){
                        continue;
                    }
                    String cmd1 = two[0].substring(0,input1.length());
                    String cmd2 = two[1].substring(0,input2.length());
                    if(cmd1.equals(input1) && cmd2.equals(input2)){
                        count++;
                        key = origin[i];
                    }else {
                        continue;
                    }
                }
            }
        }

        if(count == 1){
            System.out.println(map.get(key));
        }else {
            System.out.println(map.get("he he"));
        }

    }

}

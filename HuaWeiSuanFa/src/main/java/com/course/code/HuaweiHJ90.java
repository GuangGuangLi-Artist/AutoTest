package com.course.code;

import java.util.Scanner;

/**
 * 合法IP
 *
 * IPV4地址可以用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此正号不需要出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 *
 * 现在需要你用程序来判断IP是否合法
 *
 *
 * 输入一个ip地址，保证不包含空格
 *
 * 返回判断的结果YES or NO
 * 输入：
 * 255.255.255.1000
 * 输出：
 * NO
 *
 */
public class HuaweiHJ90 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String[] split = sc.next().split("\\.");
            boolean flags = true;
            for(int i = 0; i < split.length; i++) {
                if(split.length != 4  || split[i].equals("")){  //如果长度不等于4，或者中间有空的字段如：2..3.5
                    flags = false;
                    break;
                }
                if(split[i].length() <0 || split[i].length() >3) {  //拆分后的字符串长度小于0或大于3说明不合法
                    flags =false;
                    break;
                }
                if(split[i].length() == 1) {  // 如果长度为1
                    if(split[i].equals("0")) {
                        flags = true;
                    } else if(split[i].charAt(0) < '0' || split[i].charAt(0) > '9') {  //长度为1时，不是1-9不合法
                        flags = false;
                        break;
                    }
                } else {   //如果长度不为1
                    // 首字符为0或不是数字
                    char c = split[i].charAt(0);
                    if( c =='0' || !(c>='1' && c<='9')) {
                        flags = false;
                        break;
                    } else{
                        int temp = Integer.parseInt(split[i]);
                        if(temp<0 || temp >255) {
                            flags = false;
                            break;
                        }
                    }
                }
            }
            if(flags)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

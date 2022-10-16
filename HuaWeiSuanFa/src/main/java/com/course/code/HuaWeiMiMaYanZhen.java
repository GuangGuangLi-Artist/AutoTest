package com.course.code;

import java.util.Scanner;

/**
 * 描述
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
 * 输入描述：
 * 一组字符串。
 *
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入：
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出：
 * OK
 * NG
 * NG
 * OK
 */

public class HuaWeiMiMaYanZhen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String passWord = scanner.nextLine();
            //将输入的密码转换为 字符数组
            char [] pasChars = passWord.toCharArray();
            if(passWord.length() >8){
                //只有密码超过八位
                int a = 0, b = 0, e = 0, d = 0;
                boolean err = true;
                for (char cp: pasChars){
                    //数字 密码中存在的数字的个数
                    if(cp >= '0' && cp <= '9'){
                        a = 1;
                    }else if( cp >= 'a' && cp <= 'z'){
                        b = 1;
                    }else  if(cp >= 'A' && cp <= 'Z'){
                        d = 1;
                    }else if( cp == ' ' || cp == '\n'){
                        //存在空格或者换行
                        err = false;
                        break;
                    }else {
                        e = 1;
                    }
                }
                if(err){
                    //如果不存在存在空格或者换行
                    if(a + b + d + e >= 3){
                        //如果存在 数字 大小写字母 其他字符 任意三种字符
                        if(reStr(passWord)){
                            System.out.println("OK");

                        }else {//存在重复字符
                            System.out.println("NG");
                        }

                    }else {
                        //字符种类小于三种
                        System.out.println("NG");
                    }
                }else {
                    //字符串中存在空格
                    System.out.println("NG");
                }
            }else {
                //字符串密码长度小于8
                System.out.println("NG");
            }
        }
    }

    private static boolean reStr(String s){//Ab0Ab0%^12345
        for (int i = 3; i < s.length(); i++) {
            if(s.substring(i).contains(s.substring(i - 3,i))){
                //有长度大于2的包含公共元素的子串重复
                return false;
            }
        }
        return  true;
    }


}

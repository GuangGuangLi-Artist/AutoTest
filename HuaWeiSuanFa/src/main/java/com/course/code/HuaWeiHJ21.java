package com.course.code;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * 现在有一种密码变换算法。
 * 九键手机键盘上的数字与字母的对应： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，把密码中出现的小写字母都变成九键键盘对应的数字，如：a 变成 2，x 变成 9.
 * 而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，例外：Z 往后移是 a 。
 * 数字和其它的符号都不做变换。
 * 数据范围： 输入的字符串长度满足 1≤n≤100
 * 输入描述：
 * 输入一组密码，长度不超过100个字符。
 *
 * 输出描述：
 * 输出密码变换后的字符串
 *
 * 输入：
 * YUANzhi1987
 * 输出：
 * zvbo9441987
 */

public class HuaWeiHJ21 {

    static HashMap<String,String> map = new HashMap<>();

    static {
        map.put("1","1");
        map.put("abc","2");
        map.put("def","3");
        map.put("ghi","4");
        map.put("jkl","5");
        map.put("mno","6");
        map.put("pqrs","7");
        map.put("tuv","8");
        map.put("wxyz","9");
        map.put("0","0");
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String resource = scanner.nextLine();

        char[] chs = resource.toCharArray();

        StringBuffer res = new StringBuffer();

        //循环拿到每一个字符
        for (int i = 0; i < chs.length; i++) {
            if(chs[i] >= '0' && chs[i] <='9'){//数字
                res.append(String.valueOf(chs[i]));
            }else if(chs[i] >= 'A' && chs[i] <= 'Y'){
                char newChar = (char) (chs[i]+32+1);//如果是A~Y的大写字母则需要将其+32位转换成小写再向后移1位
                res.append(String.valueOf(newChar));
            }else if(chs[i] == 'Z'){
                res.append(String.valueOf('a'));
            }else {//小写字母
                Set<String> keys = map.keySet();
                for (String keyStr: keys){
                    if(keyStr.contains(String.valueOf(chs[i]))){
                        res.append(map.get(keyStr));
                    }
                }
            }
        }

        System.out.println(res.toString());


    }
}

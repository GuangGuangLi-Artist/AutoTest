package com.course.code;

import java.util.Scanner;

/**
 * 描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 *
 * 输入：
 *
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 *
 * 坐标之间以;分隔。
 *
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 *
 * 下面是一个简单的例子 如：
 *
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 *
 * 处理过程：
 *
 * 起点（0,0）
 *
 * +   A10   =  （-10,0）
 *
 * +   S20   =  (-10,-20)
 *
 * +   W10  =  (-10,-10)
 *
 * +   D30  =  (20,-10)
 *
 * +   x    =  无效
 *
 * +   A1A   =  无效
 *
 * +   B10A11   =  无效
 *
 * +  一个空 不影响
 *
 * +   A10  =  (10,-10)
 *
 * 结果 （10， -10）
 *
 * 数据范围：每组输入的字符串长度满足 1\le n \le 10000 \1≤n≤10000  ，坐标保证满足 -2^{31} \le x,y \le 2^{31}-1 \−2
 * 31
 *  ≤x,y≤2
 * 31
 *  −1  ，且数字部分仅含正数
 * 输入描述：
 * 一行字符串
 *
 * 输出描述：
 * 最终坐标，以逗号分隔
 *
 * 示例1
 * 输入：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 复制
 * 输出：
 * 10,-10
 */

public class HuaWeiZuoBiao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s1 = in.nextLine();
        String[] sch = s1.split(";");//获取字符数组

        //定义坐标
        int x = 0;
        int y = 0;

        for(String s : sch){
            if(!(s.matches("[WASD][0-9]{1,2}"))){//[] 表示匹配[]中列举的字符;{m,n}匹配一个字符出现从m到n次
                continue;

            }
            int val = Integer.valueOf(s.substring(1)); //substring()  返回一个新的字符串，它是此字符串的一个子字符串。该子字符串从指定索引处的字符开始，直到此字符串末尾。 valueOf() 返回保存指定的String 的值的Integer对象。
            switch(s.charAt(0)){
                case 'W':
                    y += val;//W表示向上移动
                    break;
                case 'S':
                    y -= val;//S表示向下移动
                    break;

                case 'A':
                    x -= val;//A表示向左移动
                    break;
                case 'D':
                    x += val;//D表示向右移动
                    break;

            }
        }
        System.out.println(x + ","  + y);
    }
}

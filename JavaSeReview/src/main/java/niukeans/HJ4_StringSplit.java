package niukeans;


import java.util.Scanner;

/**
 * 对于给定的由小写字母和数字混合构成的字符串 ss，你需要按每 88 个字符换一行的方式书写它，具体地：
 * 书写前 88 个字符，换行；
 * 书写接下来的 88 个字符，换行；
 *
 * ∙重复上述过程，直到字符串被完全书写。
 * 特别地，如果最后一行不满 88 个字符，则需要在字符串末尾补充 00，直到长度为 88。
 * 输入描述：
 * 在一行上输入一个长度 1≦length(s)≦1001≦length(s)≦100，由小写字母和数字构成的字符串 ss。
 * 输出描述：
 * 输出若干行，每行输出 88 个字符，代表按题意书写的结果。
 *
 * 输入：

 * hellonowcoder

 * 输出：

 * hellonow
 * coder000

 * 在这个样例中，字符串长度为 1313，因此需要在第二行末尾补充 33 个 00。
 */
public class HJ4_StringSplit {
    public static void main(String[] args) {
        //hellonowcoder 13
        Scanner in = new Scanner(System.in);
        String ss = in.nextLine();
        int len = ss.length(); //13
        int i = 0;

        while(i < len) {
            //取最多8个字符
            int end = Math.min( i + 8,len);//8 13
            String chunk = ss.substring(i,end);//hellonow coder

            //如果不足8个，补0
            if(chunk.length() < 8) {
                StringBuilder sv = new StringBuilder(chunk);
                while(sv.length() < 8){
                    sv.append('0');

                }
                chunk = sv.toString();

            }

            System.out.println(chunk);
            i+=8;
        }
    }
}

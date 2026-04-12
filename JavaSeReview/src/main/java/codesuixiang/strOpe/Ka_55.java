package codesuixiang.strOpe;

import java.util.Scanner;

/**
 *
 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
 例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。

 输入共包含两行，第一行为一个正整数 k，代表右旋转的位数。第二行为字符串 s，代表需要旋转的字符串。
 输出共一行，为进行了右旋转操作后的字符串。
 */
public class Ka_55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();

        int len = s.length();//获取字符串长度
        char[] chs = s.toCharArray();
        //反转整个字符串 abcdefg  ->gfedcba
        reverString(chs, 0, len - 1);

        //反转前一段字符串，此时的字符串首尾尾是0,n - 1 ->fgedcba
        reverString(chs,0,n-1);

        //反转后一段字符串，此时的字符串首尾尾是n,len - 1
        reverString(chs,n,len-1); //fgabcde

        System.out.println(new String(chs));


    }


    public static void reverString(char[] ch,int start,int end){

        //反转字符串
        while(start<end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }

    }

}

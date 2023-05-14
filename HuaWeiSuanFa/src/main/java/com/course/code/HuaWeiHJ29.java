package com.course.code;


import java.util.Scanner;

/**
 *
 * 字符串加解密
 * 对输入的字符串进行加解密，并输出。
 *
 * 加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 解密方法为加密的逆过程。
 * 数据范围：输入的两个字符串长度满足
 *
 * 1≤n≤1000  ，保证输入的字符串都是只由大小写字母或者数字组成
 *
 * 这个是考查字符串的字母替换。思路如下：
 *
 * 准备三组数据分别是大写字母、小写字母、数字；
 * 大写字母要替换为小写字母、小写字母要替换为大写字母、数字替换为数字；
 * 加密是替换为后一位的，解密就是替换为前一位。
 */
public class HuaWeiHJ29 {

    private static char[] UP_LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static  char[] LOW_LETTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String in2 = sc.nextLine();

        System.out.println(String.valueOf(encrypt(in.toCharArray())));
        System.out.println(String.valueOf(decrypt(in2.toCharArray())));

    }



    //加密
    private static char[] encrypt(char[] words) {
        char[] result = new char[words.length];
        for (int i = 0; i < words.length; i++) {
            char word = words[i];
            if(Character.isUpperCase(word)){
                int j = findIndex(word,UP_LETTERS);
                j++;
                if(j == LOW_LETTERS.length){
                    j=0;
                }
                result[i] = LOW_LETTERS[j];
            }else if(Character.isLowerCase(word)){
                int j = findIndex(word,LOW_LETTERS);
                j++;
                if(j == UP_LETTERS.length){
                    j = 0;
                }
                result[i] = UP_LETTERS[j];
            }else if(Character.isDigit(word)){
                int j = findIndex(word,DIGITS);
                j++;
                if(j == DIGITS.length){
                    j = 0;
                }
                result[i] = DIGITS[j];
            }else {
                result[i] = word;
            }

        }
        return result;
    }




    private static char[] decrypt(char[] words) {

        char[] result = new char[words.length];
        for (int i = 0; i < words.length; i++) {
            char word = words[i];
            if(Character.isUpperCase(word)){
                int j = findIndex(word,UP_LETTERS);
                j--;
                if(j<0){
                    j = LOW_LETTERS.length - 1;
                }

                result[i] = LOW_LETTERS[j];
            }else if(Character.isLowerCase(word)){
                int j = findIndex(word,LOW_LETTERS);
                j--;

                if(j<0){
                    j = UP_LETTERS.length -1;
                }
                result[i] = UP_LETTERS[j];
            }else if(Character.isDigit(word)){
                int j = findIndex(word,DIGITS);
                j--;

                if(j<0){
                    j = DIGITS.length -1;
                }
                result[i] = DIGITS[j];
            }else {
                result[i] = word;
            }
        }

        return result;
    }


    private static int findIndex(char ch, char words[]) {
        for (int i = 0; i < words.length; i++) {
            if(ch == words[i]){
                return i;
            }
        }

        return -1;
    }

}

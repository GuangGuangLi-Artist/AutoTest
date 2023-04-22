package com.course.code;


import java.util.*;

/**
 *
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
 * 现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
 * 注意：字典中可能有重复单词。
 *
 * 输入描述：
 * 输入只有一行。 先输入字典中单词的个数n，再输入n个单词作为字典单词。 然后输入一个单词x 最后后输入一个整数k
 *
 * 输出描述：
 * 第一行输出查找到x的兄弟单词的个数m 第二行输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 *
 * 输入：3 abc bca cab abc 1
 * 输出：2
 *      bca
 */
public class HuaWeiHJ27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String[] s1 = scanner.nextLine().split(" ");

            //多少个字符串
            int n = Integer.parseInt(s1[0]);

            //第x位置的字符串
            String x = s1[s1.length - 2];
            int k = Integer.parseInt(s1[s1.length -1]);


            //创建字符串list 判断单词是否是兄弟单词，是则添加到list中
            List<String> ls = new ArrayList<>();
            for (int i = 1; i <=n ; i++) {
                if(isBrother(x,s1[i])){
                    ls.add(s1[i]);
                }
            }
            System.out.println(ls.size());//输出兄弟单词个数

            Collections.sort(ls); //字母排序
            if(ls.size() >= k){
                System.out.println(ls.get(k - 1));
            }
        }


    }
    //将x和要比较的单词拆分为字符重新排序后比较
    public static boolean isBrother(String x,String s){
        if(x.length() != s.length() || s.equals(x)){
            return  false;
        }
        char[] cx = x.toCharArray();
        char[] cs = s.toCharArray();

        Arrays.sort(cx);
        Arrays.sort(cs);

        boolean res = new String(cx).equals(new String(cs));
        return res;
    }
}

package com.course.code;

import java.util.Scanner;

/**
 * 密码截取
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无
 * 关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab
 * 可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 输入一个字符串（字符串的长度不超过2500）
 * 返回有效密码串的最大长度
 *
 *
 * 解法
 * 那就是不断尝试遍历来查找最优解。
 *
 * 针对ABA型：可以先取字符串的第二个字符作为中间位置开始尝试（第一个字形成不了对称，所以无需尝试），直到字符串的倒数第二个字符为止。而后从该中间位置往两边不断尝试，如果两边不对称，则从中间位置查找下个位置作为中间位置，再次尝试，直到所有位置尝试完成。
 * 针对ABBA型：可以先取字符串的第1个字符作为中间位置的左半边开始尝试，直到字符串的倒数第二个字符为止。如果找到了右边与左半边相同的字符，则这两个字符组成中间位置，而后从该中间位置往两边不断尝试，如果两边不对称，则从中间位置查找下个位置作为中间位置，再次尝试，直到所有位置尝试完成。
 *
 */
public class HuaWeiHJ32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();

        int len = 1;
        int maxlen = 1;
        // 先处理ABA型
        for (int i = 1; i < chars.length - 2; i++) {
            int leftIndex = i - 1;
            int rightIndex = i + 1;
            //向左向右尝试 不要超过边界
            while (leftIndex >= 0 && rightIndex <= chars.length - 1 ){
                //左右对称 则尝试下个位置
                if(chars[leftIndex] == chars[rightIndex]){
                    len = rightIndex - leftIndex + 1;
                    leftIndex--;
                    rightIndex++;

                    maxlen = Math.max(maxlen,len);
                }else {
                    break;
                }
            }
        }

        //再处理ABBA型
        for (int i = 1; i < chars.length - 2; i++) {
            int leftIndex = i -1;
            int rightIndex = i + 2;

            while (leftIndex >= 0 && rightIndex <= chars.length - 1){
                if(chars[i] == chars[i+1] && (chars[leftIndex]) == chars[rightIndex]){
                    len = rightIndex - leftIndex + 1;
                    leftIndex--;
                    rightIndex++;

                    maxlen = Math.max(maxlen,len);
                }else{
                    break;
                }
            }
        }
        System.out.println(maxlen);
        scanner.close();
    }
}

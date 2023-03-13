package com.course.code;

import java.util.Scanner;

/**
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 *
 * 一、密码长度:
 * 5 分: 小于等于4 个字符
 * 10 分: 5 到7 字符
 * 25 分: 大于等于8 个字符
 *
 * 二、字母:
 * 0 分: 没有字母
 * 10 分: 密码里的字母全都是小（大）写字母
 * 20 分: 密码里的字母符合”大小写混合“
 *
 * 三、数字:
 * 0 分: 没有数字
 * 10 分: 1 个数字
 * 20 分: 大于1 个数字
 *
 * 四、符号:
 * 0 分: 没有符号
 * 10 分: 1 个符号
 * 25 分: 大于1 个符号
 *
 * 五、奖励（只能选符合最多的那一种奖励）:
 * 2 分: 字母和数字
 * 3 分: 字母、数字和符号
 * 5 分: 大小写字母、数字和符号
 *
 * 最后的评分标准:
 * >= 90: 非常安全
 * >= 80: 安全（Secure）
 * >= 70: 非常强
 * >= 60: 强（Strong）
 * >= 50: 一般（Average）
 * >= 25: 弱（Weak）
 * >= 0:  非常弱（Very_Weak）
 *
 * 对应输出为：
 *
 * VERY_SECURE
 * SECURE
 * VERY_STRONG
 * STRONG
 * AVERAGE
 * WEAK
 * VERY_WEAK
 *
 * 请根据输入的密码字符串，进行安全评定
 */

public class HuaweiHJ87 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            char[] chs = line.toCharArray();

            int score = 0;
            int num = 0;
            int upper = 0;
            int lower = 0;
            int simple = 0;

            for (int i = 0; i < chs.length; i++) {
                if(chs[i] >= '0' && chs[i] <= '9'){
                    num++;
                }else if(chs[i] >= 'a' && chs[i] <= 'z'){
                    lower++;
                }else if(chs[i] >= 'A' && chs[i] <= 'Z'){
                    upper++;
                }else {
                    simple++;
                }
            }

            //判断长度
            if(chs.length>=0 && chs.length<=4){
                score  = score + 5;
            }else if(chs.length >=5 && chs.length <= 7){
                score = score + 10;
            }else {
                score = score + 25;
            }

            //判断字母
            if(lower == 0 && upper == 0){
                score = score + 0;
            }else if(lower != 0 && upper != 0) {
                score = score + 20;
            }else {
                score = score + 10;
            }

            //判断数字
            if(num == 0){
                score = score + 0;
            }else if(num == 1) {
                score = score + 10;
            }else {
                score = score + 20;
            }

            //判断符号
            if(simple == 0){
                score = score + 0;
            }else if(simple == 1) {
                score = score + 10;
            }else {
                score = score + 20;
            }

            //奖励

            if(num != 0 && lower != 0 && upper != 0 && simple !=0){
                score = score + 5;
            }else if(num != 0 && simple != 0 && (lower != 0 || upper != 0)){
                score = score + 3;
            }else {
                score =  score + 2;
            }
            if(score >= 90){
                System.out.println("VERY_SECURE");
            }else if(score >= 80 && score < 90){
                System.out.println("SECURE");
            }else if(score >= 70 && score < 80){
                System.out.println("VERY_STRONG");
            }else if(score >= 60 && score < 70){
                System.out.println("STRONG");
            }else if(score >= 50 && score < 60){
                System.out.println("AVERAGE");
            }else if(score >= 25 && score < 50){
                System.out.println("WEAK");
            }else if(score >= 0 && score < 25){
                System.out.println("VERY_WEAK");
            }


        }


    }
}

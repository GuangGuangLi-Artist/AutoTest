package com.course.code;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 求小球落地5次后所经历的路程和第5次反弹的高度
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 *
 * 输入起始高度，int型
 *
 * 分别输出第5次落地时，共经过多少米以及第5次反弹多高。
 */
public class HuaWeiHJ38 {
    private  static final BigDecimal TWO = BigDecimal.valueOf(2);
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BigDecimal in = scanner.nextBigDecimal();

        System.out.println(getDistance(in,5));
        System.out.println(getHight(in,5));

    }

    private static BigDecimal getDistance(BigDecimal hight,int n){
        //第5经过的记录为第1次下落的距离+ 第2-4次起落的距离
        BigDecimal dist = hight;

        //首次起落
        BigDecimal before = hight.multiply(TWO);//返回其值为 (this × multiplicand) 的 BigDecimal（根据上下文设置进行舍入）。

        // 后续的起落距离为前次起落距离的一半
        for (int i = 2; i <= n ; i++) {
            before = before.divide(TWO);
            dist = dist.add(before);
        }
        // 首次只有落，没有起，所以减掉高度
        return dist;

    }

    private static BigDecimal getHight(BigDecimal hight, int n){

        // 后续的起落距离为前次起落距离的一半
        for (int i = 1; i <= n ; i++) {
            hight = hight.divide(TWO);
        }

        return hight;
    }
}

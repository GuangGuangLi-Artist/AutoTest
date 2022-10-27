package com.course.code;

import java.util.Scanner;

/**
 *描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 *
 * 数据范围：1≤n≤2×10^9 +14
 * 输入描述：
 * 输入一个整数
 *
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 *
 * 示例1
 * 输入：180
 * 输出：
 * 2 2 3 3 5
 * 复制
 */

public class HuaWeiPrimeNumber {

    /**
     * 具体做法：
     *
     * 首先我们要知道三个点：
     *
     * 1没有算在这个质因数里面，但是如果这个数本来就是质数，那么它本身就是它的质因数。
     *
     * 所有的合数都是由质数相乘得到的，只要一个数把质因数全部除掉，它就不会有合因数了。
     *
     * 一个数的质因数不会超过它的算术平方根
     *
     * 那我们可以从2遍历到该数的算术平方根，然后检查是否是因子，如果是则将这个因子全部除尽且输出，再进入下一个。我们最后需要检查这个数本身就是质数的情况，因为在上述过程中它的大小没有变，所以只要它大于1，我们就可以输出这个质数。
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        StringBuffer sb = new StringBuffer();

        for (int i=2;i<=Math.sqrt(num);){//Math.sqrt 开平方 180  90
            if( num % i == 0){
                sb.append(i).append(" ");//2 2 3 3 5
                num = num / i;//90 45 15 5
            }else {
                i++;  //3 4 5
            }
        }
        sb.append(num).append(" ");
        System.out.println(sb.toString());
    }


}

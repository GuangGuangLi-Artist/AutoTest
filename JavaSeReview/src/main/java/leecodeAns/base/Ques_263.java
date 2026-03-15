package leecodeAns.base;

public class Ques_263 {

    /**
     * 丑数 就是只包含质因数 2、3 和 5 的 正 整数。
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     * 输入：n = 6
     * 输出：true
     * 解释：6 = 2 × 3
     *
     * @param args
     */

    public static void main(String[] args) {

        int n = 7;
        System.out.println(isUgly(n));

//        System.out.println(Math.pow(3,19));

    }


    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        // 如果是2的幂 那么 n & （n- 1） 一定是0
        return (n & (n - 1)) == 0;
    }
}

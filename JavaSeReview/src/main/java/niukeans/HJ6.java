package niukeans;

import java.util.Scanner;

/**
 * 对于给定的整数 nn，从小到大依次输出它的全部质因子。即找到这样的质数 p1,p2,⋯ ,pkp1​,p2​,⋯,pk​，使得 n=p1×p2×⋯×pkn=p1​×p2​×⋯×p
 *
 * 在一行上输入一个整数 n(2≦n≦2×109+14)n(2≦n≦2×109+14) 代表待分解的整数。
 * 在一行上从小到大输出若干个整数，代表 nn 的质因子。
 * 输入：
 *
 * 180
 *
 * 输出：
 *
 * 2 2 3 3 5
 *
 * 说明：
 *
 * 在这个样例中，180=2×2×3×3×5180=2×2×3×3×5。
 */
public class HJ6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /**
         * 从最小的质数 2 开始，不断尝试除以当前数 i；
         * 如果能整除，则 i 是一个质因子，记录下来，并将 n 除以 i；
         * 继续用同一个 i 试除（因为可能有多个相同因子）；
         * 当 i*i > n 时，如果此时 n > 1，则剩下的 n 本身就是一个质数（最大的那个因子）；
         * 停止条件：n == 1 或 i*i > n。
         */

        int n = in.nextInt();

        for(int i = 2; i * i<= n; i++){

            while(n % i == 0){
                System.out.print(i + " ");
                n /= i;
            }
        }

        //如果最后n>1，说明剩下的是一个质数
        if(n > 1) {
            System.out.print(n);
        }

        System.out.println(); // 换行



    }
}

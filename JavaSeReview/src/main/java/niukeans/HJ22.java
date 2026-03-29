package niukeans;

import java.util.Scanner;

/**
 *
 */

public class HJ22 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (true) { // 注意 while 处理多个 case
            int n = in.nextInt();
            if(n == 0) {
                break;
            }

            int total = 0;
            while(n >= 2) {
                if(n >= 3) {
                    int exchange = n / 3;
                    total += exchange;
                    n = n % 3 + exchange;
                }else{// n == 2
                    total += 1;
                    n = 0;// 借1换1，喝完还1，归零

                }
            }
            System.out.println(total);
        }
    }
}

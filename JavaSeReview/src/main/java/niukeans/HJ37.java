package niukeans;

import java.util.Scanner;

public class HJ37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n==1 || n==2){
            System.out.println(1);
            return;
        }

        int a = 1;// F(1)
        int b = 1;// F(2)
        int c = 0;

        //月:   1  2  3  4  5  6  7 ...
        //数:   1  1  2  3  5  8 13 ...

        for (int i = 3; i <=n ; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(b);
    }
}

package niukeans;

import java.util.Scanner;

public class HJ61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int appleCount = in.nextInt();//苹果数
            int panCount = in.nextInt();

            System.out.println(dfs(appleCount, panCount));

        }

    }

    /**
     * apple 苹果数
     * pan 盘子数
     */

    public static int dfs(int apple, int pan) {
        // 边界条件：苹果没了，或只有一个盘子，只有一种方法
        if (apple == 0 || pan == 1) {
            return 1;
        }

        //终止条件：盘子用完了但苹果没分完
        if (pan > apple) {
            return dfs(apple, apple);
        }

        return dfs(apple, pan - 1) + dfs(apple - pan, pan);
    }
}

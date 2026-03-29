package niukeans;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ81 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            String b = in.next();

            //创建一个 HashSet 用来存储 t 中出现的所有字符
            Set<Character> set = new HashSet<>();

            for (char ch : b.toCharArray()) {
                set.add(ch);
            }

            //判断所有的a中的字符set中有没有
            for (char ch : a.toCharArray()) {
                if (set.contains(ch)) {
                    //什么都不做 进行下一次循环

                } else {
                    System.out.println("false");
                }
            }

            System.out.println("true");


        }
        in.close();
    }
}

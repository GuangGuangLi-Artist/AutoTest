package niukeans;

import java.util.Scanner;

public class HJ34 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            //Ihave1nose2hands10fingers
            String line = sc.nextLine();

            //ASCII 码最大是 127，开一个桶
            int [] counts = new int[128];

            //统计频次
            for(char c : line.toCharArray()) {
                counts[c]++;
            }
            //2. 按 ASCII 顺序输出 (天然有序)
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 128; i++) {
                while (counts[i] > 0) {
                    sb.append((char)i);
                    counts[i]--;
                }
            }
            System.out.println(sb.toString());


        }

    }
}

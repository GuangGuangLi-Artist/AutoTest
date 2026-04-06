package niukeans;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SysTest {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String string = sc.nextLine();
//            String[] split = string.split(" ");
//            for (int i = 0; i < split.length; i++) {
//                int sum = 0;
//                sum += Integer.valueOf(split[i]);
//            }
//        }
//    }




//    public  static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        // 注意 hasNext 和 hasNextLine 的区别
//        for (int i=0;i<t;i++) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int len = in.nextInt();//长度
//        String ss = in.nextLine();//字符串
//        // 注意 hasNext 和 hasNextLine 的区别
//        char[] chs = ss.toCharArray();
//        int left =0;
//        int right = len -1;
//
//        while(left < right){
//            char temp = chs[left];
//            chs[left] = chs[right];
//            chs[right] = temp;
//            left++;
//            right--;
//        }
//
//        String news = new String(chs);
//        System.out.println(news);
//    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            double v = Math.PI * a * a;
            System.out.println(v);
        }
    }


    @Test
    public  void testChar(){
        char aNum = 'a';
        char ANum = 'A';
        System.out.println((int)(aNum)  + ": " + (int)(ANum) );




        int n = 83;
        System.out.println(n / 3);//显示除法结果
        System.out.println(n % 3); //显示余数
    }
}

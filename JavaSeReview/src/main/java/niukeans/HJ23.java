package niukeans;

import java.util.*;

public class HJ23 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String resource = in.next();
            char[] chs = resource.toCharArray();

            Map<Character,Integer> maps = new HashMap<>();

            for(char ch: chs){
                maps.put(ch,maps.getOrDefault(ch,0) + 1);
            }

            maps.forEach((k,v) -> System.out.println(k + "--" + v));


            //  这是方法一  找到最小频次的方法做的时候卡住了
            //int min = Integer.MIN_VALUE;//-2147483648
           /* int min = Integer.MAX_VALUE;//2147483647
            System.out.println(min);
            Set<Character> ketset = maps.keySet();
            for(Character cha: ketset) {
                if(maps.get(cha) < min) {//找到最小的频次
                    min = maps.get(cha);

                }

            }*/

            //使用方法二  从map的值的集合中找最小值
            Collection<Integer> values = maps.values();
            Integer min = Collections.min(values);

            //构建结果
            StringBuilder bd = new StringBuilder();
            for(char ch: chs){
                if(maps.get(ch) > min) {
                    bd.append(ch);
                }

            }

            System.out.println(bd.toString());


        }
    }
}

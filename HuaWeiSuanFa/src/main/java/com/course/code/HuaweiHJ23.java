package com.course.code;

import java.util.*;

public class HuaweiHJ23 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String resource = in.nextLine();
            char [] chs = resource.toCharArray();
            Map<Character,Integer> chsMap = new HashMap<Character,Integer>();

            for(Character ch: chs){
                if(chsMap.containsKey(ch)){
                    chsMap.put(ch,chsMap.get(ch) + 1);
                }else{
                    chsMap.put(ch,1);
                }
            }

//            for (Character c: chsMap.keySet()){
//                System.out.println(c + "==" + chsMap.get(c));
//            }

            //获取最小的数
            Collection<Integer> integerCollection = chsMap.values();
            Integer min = Collections.min(integerCollection);

            for(Character c: chsMap.keySet()){
                if(chsMap.get(c)  == min){
                    resource = resource.replaceAll(String.valueOf(c),"");
                }

            }

            System.out.println(resource);


        }
    }
}


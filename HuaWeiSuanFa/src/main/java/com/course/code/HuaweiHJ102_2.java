package com.course.code;

import java.util.*;

public class HuaweiHJ102_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resource = scanner.nextLine();
        char[] chs = resource.toCharArray();
        HashMap<Character, Integer> newMap = new HashMap<>();

        for (Character character:chs){

            if(newMap.containsKey(character)){
                newMap.put(character,newMap.get(character)+1);
            }else {
                newMap.put(character,1);
            }
        }

        //Set<Map.Entry<Character, Integer>> set = newMap.entrySet();
        //System.out.println(set.toString());[a=2, b=3, c=3]
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(newMap.entrySet());
        //System.out.println(list.toString());[a=2, b=3, c=3]
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue())==0?
                        (int)o2.getKey() - (int) o1.getKey()
                        :o1.getValue().compareTo(o2.getValue());

            }
        }.reversed());

        StringBuffer sb = new StringBuffer();

        for (Map.Entry<Character,Integer> maps:list){
            sb.append(maps.getKey());
        }
        sb.append("\n");
        System.out.println(sb.toString());




    }

}

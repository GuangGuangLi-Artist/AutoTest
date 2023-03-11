package com.course.code;


import java.util.*;

public class HuaweiHJ102 {

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

        //找到max值
        int max = 0;
        for (int value: newMap.values()){
            if(value>max){
                max = value;
            }
        }

        while (max>0){
            for (char key: newMap.keySet()){
                if(newMap.get(key)==max){
                    System.out.print(key);
                }
            }
            max--;
        }

    }
}

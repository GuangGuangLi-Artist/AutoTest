package codesuixiang.stackDeeque;

import java.util.*;

public class Ainterview {


    public static void main(String[] args){


        //找出列表中重复数字最多的数字以及它的重复次数
        int[] testList = {1,5,7,3,3,6,7,8,9,3,2,7,4,3,9,7,0};

        Map<Integer,Integer> maps = new HashMap<Integer, Integer>();

        for(int i=0; i <testList.length;i++ ){
            if(maps.containsKey(testList[i])){
                maps.put(testList[i],maps.get(testList[i])+1);
            }else{
                maps.put(testList[i],1);
            }
        }

        //获取最大
        int count = 0;
        for(int i: maps.values()){
            if(i > count){
                count = i;
            }
        }

        //获取值
        List<Integer> res = new ArrayList<Integer>();
        Set<Integer> sets = maps.keySet();
        for(int i:sets){
            if(maps.get(i) ==count ){
                res.add(i);
            }
        }

        System.out.println(Arrays.toString(res.toArray()));
        System.out.println(count);



    }



}

package com.course.code.commonFunction;

import org.testng.annotations.Test;

import java.util.*;

public class MapReview {

    @Test
    public void testMap()  {

        HashMap<Integer,String> map = new HashMap<>();

        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王五");

        //map使用entrySet遍历 键值对遍历
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(  key + " : " + value);

        }


        System.out.println("根据键获取值");
        Set<Integer> keySet = map.keySet();
        for (Integer i : keySet) {
            System.out.println(i + " : " + map.get(i));
        }

    }

    //复习一下Collections的方法

    @Test
    public void testCollectionTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(3);

        Collections.sort(list);
        list.stream().forEach(System.out::println);
        System.out.println("-----------");

        int binarySearch = Collections.binarySearch(list, 5);
        System.out.println(binarySearch);
        System.out.println("-----------");
        Collections.reverse(list);
        list.stream().forEach(System.out::println);

        System.out.println("-----------");
        Collections.shuffle(list);
        list.stream().forEach(System.out::println);
        System.out.println("-----------");
        Collections.replaceAll(list, 7, 77);
        list.stream().forEach(System.out::println);


    }
}



package com.course.code.functionalProgramming;


import org.testng.annotations.Test;

import java.util.*;

/**
 * Collection:removeIf() spliterator() stream() parallelStream() forEach()
 * List:replaceAll() sort()
 * Map:getOrDefault() forEach() replaceAll() putIfAbsent() remove() replace() computeIfAbsent() computeIfPresent() compute() merge()
 */
public class LambdaCollections {





    @Test
    public void testList_forEach() {
        //forEach() 作用是对容器中的每个元素执行action指定的动作
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.forEach(s -> {
            if(s.length() >= 3){
                System.out.println("forEach(): " + s);
            }
        });
    }

    @Test
    public void testList_removeIf() {
        //removeIf() 作用是删除容器中所有满足filter指定条件的元素
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.removeIf(s -> s.length() > 3);
        list.forEach(System.out::println);
    }

    @Test
    public void testList_replaceAll(){
        //replaceAll() 作用是对每个元素执行operator指定的操作，并用操作结果来替换原来的元素。
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.replaceAll(s -> {
            if(s.length() >= 3){
                 return s.toUpperCase();
            }
            return s;
        });

        list.forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    public void testList_sort(){
        //sort() 该方法根据c指定的比较规则对容器元素进行排序。
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.sort((str1,str2) -> str1.length() - str2.length());

        list.forEach(System.out::println);
    }

    public void testList_spliterator(){

        //spliterator() 该方法返回容器的可拆分迭代器
        //1.Spliterator既可以像Iterator那样逐个迭代，也可以批量迭代。批量迭代可以降低迭代的开销。
        //2.Spliterator是可拆分的，一个Spliterator可以通过调用Spliterator<T> trySplit()方法来尝试分成两个。一个是this，另一个是新返回的那个，这两个迭代器代表的元素没有重叠。
    }

    @Test
    public void testMap_forEach(){

        //作用是对Map中的每个映射执行action指定的操作
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");


        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry:entrySet){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("----");
        map.forEach((k,v) ->{
            System.out.println(k + "=" + v);
        });


    }




}

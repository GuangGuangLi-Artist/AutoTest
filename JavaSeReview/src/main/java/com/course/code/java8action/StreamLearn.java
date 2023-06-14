package com.course.code.java8action;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 一、流由三部份组成：
        1.源；
        2.零个或多个中间操作；
        3.终止操作；
 *二、流操作的分类：
 *      1.惰性求值
 *      2.及早求值
 *
 * 三、流的特点
 *      1.Collection提供了新的stream()方法。
 *      2.流不存储，通过管道的方式获取值。
 *      3.质是函数式的，对流的操作会生成一个结果，不过并不会修改底层的数据源，集合可以作为流的底层数据源。
 *      4.延迟查找，很多流操作（过滤filter、映射map、排序sort等）都可以延迟实现。
 */
public class StreamLearn {
    public static void main(String[] args) {
        //第一种创建流的方法
        Stream<String> stream1 = Stream.of("hello","stream","learnStream");


        //使用数组创建流
        String[] myArr = {"hello","arrayStream","stream"};
        Stream arrStream = Stream.of(myArr);

        //第三种方式
        Stream stream3 = Arrays.stream(myArr);

        //第四种
        List<String> list = Arrays.asList(myArr);
        Stream<String> listStream = list.stream();


        //流的使用

        IntStream.of(new int[]{3,5,8}).forEach(System.out::println);
        System.out.println("--------------");
        IntStream.range(1, 8).forEach(System.out::print);
        System.out.println("--------------");

        //整型每个乘以2再相加

        int res = IntStream.range(3, 8).map(value -> value * 2).reduce(0, (a, b) -> a + b);
        System.out.println(res);
        System.out.println("--------------");
        System.out.println(IntStream.range(3, 8).map(value -> value * 2).reduce(0, Integer::sum));
        System.out.println("--------------");

        //将流对象转换为数组
        Stream<String> streamConvertArray = Stream.of("hello","toArray","convert");
        Object[] array = streamConvertArray.toArray(le -> new String[le]);
        Arrays.asList(array).forEach(System.out::println);
        System.out.println("--------------");
        //将流对象转换为List
        Stream<String> streamConvertList = Stream.of("hello","toList","convert");
        List<String> streamList = streamConvertList.collect(Collectors.toList());
        streamList.forEach(System.out::println);


    }

}

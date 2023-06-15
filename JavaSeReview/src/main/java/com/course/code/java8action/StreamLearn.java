package com.course.code.java8action;


import java.util.*;
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
        System.out.println("--------------");
        Stream<String> streamCList = Stream.of("hello","toList","convert");
        ArrayList<String> list1 = streamCList.collect(Collectors.toCollection(ArrayList::new));
        list1.forEach(s -> System.out.println(s));
        System.out.println("--------------");

        //转换为set
        Stream<String> streamCSet = Stream.of("hello","toSet","convert");
        TreeSet<String> stringTreeSet = streamCSet.collect(Collectors.toCollection(TreeSet::new));
        stringTreeSet.forEach(s -> System.out.println(s));
        System.out.println("--------------");

        //将元素拼接为字符串
        Stream<String> streamnewString = Stream.of("hello","genererate","newStream","String");
        String upperString = streamnewString.collect(Collectors.joining(",")).toUpperCase().toString();
        System.out.println(upperString);

        System.out.println("--------------");

        //对其集合中的所有字符串元素转换成大写，然后再输出出来
        Stream<String> streamnewUpperString = Stream.of("hello","genererate","newStream","String");
        streamnewUpperString.map(String::toUpperCase).forEach(System.out::println);
        System.out.println("--------------");

        //将一个整数集合中的元素进行平方之后再打印出来
        Stream<Integer> streamPow = Stream.of(1,2,3,4,5);
        streamPow.map( x -> x * x).forEach(System.out::println);
        System.out.println("--------------");

        //将多个个整数集合中的元素进行乘以3之后再打印出来
        Stream<List<Integer>> flatMapUse = Stream.of(Arrays.asList(1),Arrays.asList(2,3),Arrays.asList(4,5,6));
        flatMapUse.flatMap( theList -> theList.stream()).map(item -> item * 3).forEach(System.out::println);
        System.out.println("--------------");


        //生成一个UUId  generate  findFirst
        Stream<String> streamUUid = Stream.generate(UUID.randomUUID()::toString);
        //System.out.println(streamUUid.findFirst().get());
        streamUUid.findFirst().ifPresent(System.out::println);


        //生成一个指定规则生成的数列
        Stream.iterate(1,item -> item + 2).limit(6).forEach(System.out::println);



    }

}

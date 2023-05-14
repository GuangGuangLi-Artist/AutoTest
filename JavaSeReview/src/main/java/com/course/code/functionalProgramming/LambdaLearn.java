package com.course.code.functionalProgramming;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class LambdaLearn {


    public static void main(String[] args) {
        String[] array = {"Apple","Orange","Bananana","Lemon"};

        //实例引用
        Arrays.sort(array,LambdaLearn::cmp);
        System.out.println(String.join(", ",array));//Apple, Bananana, Lemon, Orange

        System.out.println("=============");



        //静态方法
        Arrays.sort(array,String::compareTo);
        System.out.println(String.join(", ",array));


        //构造方法引用

        List<String> names = List.of("Bob","Alice","Tim");
        List<LPerson> persons = new ArrayList<>();
        for(String name: names){
            persons.add(new LPerson(name));
        }

        System.out.println(persons);

        System.out.println("=============");


        /**
         * 创建stream
         *      创建Stream最简单的方式是直接用Stream.of()静态方法，传入可变参数即创建了一个能输出确定元素的Stream
         *      基于数组
         *      基于Collection
         *      基于Supplier
         *      Files 类的 lines() 方法可以把一个文件变成一个 Stream ，每个元素代表文件的一行内容：此方法对于按行遍历文本文件十分有用。
         *      正则表达式的 Pattern 对象有一个 splitAsStream() 方法，可以直接把一个长字符串分割成Stream 序列而不是数组
         */

        Stream<String> stream = Stream.of("A","B","C","D","E");
        stream.forEach(System.out::println);
        System.out.println("=============");

        Stream<String> stream1 = Arrays.stream(new String[] {"A","B","C","D","E"});
        Stream<String> stream2 = List.of("A","B","C","D","E").stream();
        stream1.forEach(System.out::println);
        System.out.println("=============");
        stream2.forEach(System.out::println);
        System.out.println("=============");

        Stream<Integer> natural = Stream.generate(new NatualSupplier());
        //注意 无限序列必须先变成有限序列再打印
        natural.limit(20).forEach(System.out::print);
        System.out.println();
        System.out.println("=============");

        //正则
        Pattern p = Pattern.compile("\\s+");
        Stream<String> splitString = p.splitAsStream("zhe shi yi ge xin de chuang jian stream de xin fang shi");
        splitString.forEach(System.out::print);
        System.out.println();
        System.out.println("=============");

        //基本类型
        //将int[]数组变为IntStream:
        IntStream is = Arrays.stream(new int[]{1,2,3,});
        is.forEach(System.out::println);
        System.out.println("=============");
        //将将Stream<String>转换为LongStream:
        LongStream ls = List.of("1","2","3").stream().mapToLong(Long::parseLong);
        ls.forEach(System.out::println);
        System.out.println("=============");



        /**
         * 使用map
             * stream.map() 是 Stream 最常用的一个转换方法，它把一个 Stream 转换为另一个Stream
             *
             * 所谓 map 操作，就是把一种操作运算，映射到一个序列的每一个元素上。例如，对 x 计算它的平
             * 方，可以使用函数 f(x) = x * x 。我们把这个函数映射到一个序列1，2，3，4，5上，就得到了另
             * 一个序列1，4，9，16，25
         */

        Stream<Integer> stream3 = Stream.of(1,2,3,4,5);
        Stream<Integer> stream4 = stream3.map(n -> n * n);
        stream4.forEach(System.out::print);
        System.out.println();
        System.out.println("=============");

        List.of("  Apple ", " pear ", " ORANGE", " BaNaNa ")
                .stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .forEach(System.out::println);
        System.out.println("=============");

        /**
         * 使用filter
         *      所谓 filter() 操作，就是对一个 Stream 的所有元素一一进行测试，不满足条件的就被“滤掉”了，剩下的满足条件的元素就构成了一个新的 Stream
         */

        IntStream.of(1,2,3,4,5,6,7,8,9)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        System.out.println("=============");

        //过滤出休息日
        Stream.generate(new LocalDateSupplier())
                .limit(31)
                .filter( ldt -> ldt.getDayOfWeek() == DayOfWeek.SATURDAY || ldt.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);
        System.out.println("=============");


        /**
         * 使用reduce
         *      是 Stream 的一个聚合方法，它可以把一个 Stream 的所有元素按照聚合函数聚合成一个结果。
         */

        int sum = Stream.of(1,2,3,4,5,6,7,8,9).reduce(0,(acc,n) -> acc + n);
        System.out.println(sum);
        System.out.println("=============");


        List<String> props = List.of("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String,String> map = props.stream()
                .map(kv -> {
                    String[] ss = kv.split("\\=",2);
                    return Map.of(ss[0],ss[1]);
                }).reduce(new HashMap<String,String>(),(m,kv) -> {
                    m.putAll(kv);
                    return m;
                });

        map.forEach((k,v) ->{
            System.out.println(k + " = " + v);
        }) ;

        System.out.println("=============");


        //输出为List
        Stream<String> stream5 = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        List<String> nList  = stream5.filter(s -> s != null && !s.isBlank()).collect(Collectors.toList());
        System.out.println(nList);
        System.out.println("=============");

        //输出为数组
        List<String> list = List.of("Apple","Pear","Orange");
        String[] nArray = list.stream().toArray(String[]::new);
        System.out.println(nArray[0]+ " ," + nArray[1] + " ," + nArray[2]);
        System.out.println("=============");




        //输出为Map
        Stream<String> stream6 = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String,String> nMap = stream6
                .collect(Collectors.toMap(
                        s -> s.substring(0,s.indexOf(':')),
                        s -> s.substring(s.indexOf(':') + 1)
                ));
        System.out.println(nMap);
        System.out.println("=============");

        //分组输出
        List<String> list1 = List.of("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        Map<String,List<String>> grops = list1.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0,1),Collectors.toList()));

        System.out.println(grops);
        System.out.println("=============");


        //排序
        List<String> sList = List.of("Orange","Apple","Banana")
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sList);
        System.out.println("=============");


        List<String> sList1 = List.of("Orange","Apple","Banana")
                .stream()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
        System.out.println(sList1);
        System.out.println("=============");

        //去重
        System.out.println(
                List.of("A", "B", "A", "C", "B", "D")
                .stream()
                .distinct()
                .collect(Collectors.toList())
        );
        System.out.println("=============");

        //截取
        System.out.println(
                List.of("A", "B", "C", "D", "E", "F")
                .stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList())
        );
        System.out.println("=============");

        //flatMap


        //并行 parallel()




























    }


    static int cmp(String s1,String s2){
        return s1.compareTo(s2);
    }


}

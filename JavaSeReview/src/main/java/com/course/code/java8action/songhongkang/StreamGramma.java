package com.course.code.java8action.songhongkang;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


/**
 * Stream API
 *     流(Stream)是什么
 *         是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。
 *     Stream 的操作三个步骤
 *         创建 Stream：一个数据源（如：集合、数组），获取一个流
 *         中间操作：一个中间操作链，对数据源的数据进行处理
 *         终止操作(终端操作)：一个终止操作，执行中间操作链，并产生结果
 */
public class StreamGramma {



    // 四种方式创建Stream
    @Test
    public void testStreamOne() {

        System.out.println("1：通过Collection系列集合提供的stream() 或 parsetream()");
        List<String> list = new ArrayList<>();
        Stream<String> streamOne = list.stream();

        System.out.println("2：Arrays 的静态方法 stream()可以获取数组流");
        JavaEightObject[] objectArray = new JavaEightObject[10];
        Stream<JavaEightObject> streamTwo = Arrays.stream(objectArray);

        System.out.println("3：使用静态方法 Stream.of(), 通过显示值创建一个流");
        Stream<String> streamThree = Stream.of("a", "b", "c");

        System.out.println("4：使用静态方法 Stream.iterate() 和Stream.generate(), 创建无限流");
        System.out.println("*************** 迭代");
        Stream<Integer> streamFourIterate = Stream.iterate(0, (x) -> x + 2);
        streamFourIterate.limit(10).forEach(System.out::println);

        System.out.println("*************** 生成");
        Stream<Integer> streamFourGenerate =  Stream.generate(() -> (int)(Math.random() * 10));
        streamFourGenerate.limit(5).forEach(System.out::println);


    }


    //Stream 的中间操作

    @Test
    public void testStreamTwo() {

        /**
         * 筛选与切片
         *     filter(Predicate p): 接收 Lambda ， 从流中排除某些元素。
         *     distinct():筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
         *     limit(long maxSize):截断流，使其元素不超过给定数量。
         *     skip(long n):跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
         * 映射
         *     map(Function f):接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
         *     mapToDouble(ToDoubleFunction f):接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
         *     mapToInt(ToIntFunction f):接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
         *     mapToLong(ToLongFunction f):接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。
         *     flatMap(Function f):接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
         * 排序
         *     sorted():产生一个新流，其中按自然顺序排序
         *     sorted(Comparator comp):产生一个新流，其中按比较器顺序排序
         */

        List<JavaEightObject> eightObjects = Arrays.asList(new JavaEightObject("许巍", 35), new JavaEightObject("窦唯", 28), new JavaEightObject("汪峰", 28),
                new JavaEightObject("李志", 20), new JavaEightObject("崔永元", 40), new JavaEightObject("崔永元", 40),
                new JavaEightObject("柴静", 18));

        Stream<JavaEightObject> objecFiltertStream = eightObjects.stream()
                .filter((e) -> {
                    return e.getAge() > 28;
                });

        System.out.println("*************** filter");
        objecFiltertStream.forEach(System.out::println);

        System.out.println("*************** limit");
        eightObjects.stream()
                .filter((e) -> {
                    System.out.println("短路");
                    return e.getAge() >= 35;
                })
                .limit(2)
                .forEach(System.out::println);

        System.out.println("*************** skip");
        eightObjects.stream()
                .filter(e -> e.getAge() >= 35)
                .skip(1)
                .forEach(System.out::println);

        System.out.println("*************** distinct");
        eightObjects.stream()
                .filter(e -> e.getAge() >= 35)
                .distinct()
                .forEach(System.out::println);


        List<String> stringList = Arrays.asList("aaa","eee","ccc","ddd");
        System.out.println("*************** map");
        stringList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("*************** flatMap");
        stringList.stream()
                .flatMap( x -> getcharacterStream(x))
                .forEach(System.out::println);


        System.out.println("*************** sorted() 自然顺序排序");
        stringList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("*************** sorted(Comparator comp) 比较器顺序排序");
        eightObjects.stream()
                .sorted((o1,o2) -> {
                    if(o1.getAge() == o2.getAge()) {
                        return -o1.getName().compareTo(o2.getName());
                    }else {
                        return o1.getAge() - o2.getAge();
                    }
                })
                .forEach(System.out::println);



    }

    public Stream<Character> getcharacterStream(String str) {
        List<Character> characterList = new ArrayList<>();
        for (char c : str.toCharArray()) {
            characterList.add(c);
        }
        return characterList.stream();
    }




}

package com.course.code.java8action.songhongkang;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


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


        System.out.println("*************** 元素按照属性去重");
        List<JavaEightObject> newJeoList = Arrays.asList(new JavaEightObject("x001", 35),
                new JavaEightObject("x001", 36), new JavaEightObject("y002", 35),
                new JavaEightObject("x002", 20));

        //筛选对象 生成新的对象集合 姓名不相同 就是不同的对象 遇到姓名相同的 取年龄小的
        List<String> nameList = new ArrayList<>();
        List<JavaEightObject> eightObjectList = newJeoList.stream()
                .sorted(Comparator.comparing(JavaEightObject::getAge))
                .filter(javaEightObject -> {
                    boolean b = !nameList.contains(javaEightObject.getName());
                    nameList.add(javaEightObject.getName());
                    return b;
                }).collect(toList());

        eightObjectList.forEach(System.out::println);


    }



    public Stream<Character> getcharacterStream(String str) {
        List<Character> characterList = new ArrayList<>();
        for (char c : str.toCharArray()) {
            characterList.add(c);
        }
        return characterList.stream();
    }

    // Stream的终止操作

    @Test
    public void testStreamThree() {
        /**
         * 1 查找与匹配
         *     allMatch(Predicate p)  检查是否匹配所有元素
         *     anyMatch(Predicate p)  检查是否至少匹配一个元素
         *     noneMatch(Predicate p)  检查是否没有匹配所有元素
         *     findFirst()  返回第一个元素
         *     findAny()    返回当前流中的任意元素
         *     count()      返回流中元素总数
         *     max(Comparator c)      返回流中最大值
         *     min(Comparator c)      返回流中最小值
         *     forEach(Consumer c)      内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
         *
         * 2 归约
         *     reduce(T iden, BinaryOperator b)     可以将流中元素反复结合起来，得到一个值。
         *     reduce(BinaryOperator b)     可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
         *
         *
         * 3 收集
         *     collect(Collector c)     将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
         *     具体方法
         *         toList  List<T>    把流中元素收集到List    List<Employee> emps= list.stream().collect(Collectors.toList());
         *         toSet  Set<T>      把流中元素收集到Set     Set<Employee> emps= list.stream().collect(Collectors.toSet());
         *         toCollection    Collection<T>    把流中元素收集到创建的集合     Collection<Employee>emps=list.stream().collect(Collectors.toCollection(ArrayList::new));
         *         counting  Long    计算流中元素的个数    long count = list.stream().collect(Collectors.counting());
         *         summingInt  Integer    对流中元素的整数属性求和    inttotal=list.stream().collect(Collectors.summingInt(Employee::getSalary));
         *         averagingInt  Double    计算流中元素Integer属性的平均值    doubleavg= list.stream().collect(Collectors.averagingInt(Employee::getSalary));
         *         summarizingInt  IntSummaryStatistics    收集流中Integer属性的统计值。    IntSummaryStatisticsiss= list.stream().collect(Collectors.summarizingInt(Employee::getSalary));
         *         joining  String    连接流中每个字符串    String str= list.stream().map(Employee::getName).collect(Collectors.joining());
         *         maxBy  Optional<T>    根据比较器选择最大值    Optional<Emp>max= list.stream().collect(Collectors.maxBy(comparingInt(Employee::getSalary)));
         *         minBy  Optional<T>    根据比较器选择最小值    Optional<Emp> min = list.stream().collect(Collectors.minBy(comparingInt(Employee::getSalary)));
         *         reducing 归约产生的类型    从一个作为累加器的初始值开始，利用BinaryOperator与流中元素逐个结合，从而归约成单个值    inttotal=list.stream().collect(Collectors.reducing(0, Employee::getSalar, Integer::sum));
         *         collectingAndThen  转换函数返回的类型    包裹另一个收集器，对其结果转换函数    inthow= list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
         *         groupingBy Map<K, List<T>>    根据某属性值对流分组，属性为K，结果为V    Map<Emp.Status, List<Emp>> map= list.stream().collect(Collectors.groupingBy(Employee::getStatus));
         *         partitioningBy  Map<Boolean, List<T>>    根据true或false进行分区    Map<Boolean,List<Emp>>vd= list.stream().collect(Collectors.partitioningBy(Employee::getManage));
         */

        List<JavaEightObject> eightTerminate = Arrays.asList(new JavaEightObject("许巍", 35, JavaEightObject.Status.BUSY),
                new JavaEightObject("窦唯", 28, JavaEightObject.Status.FREE),
                new JavaEightObject("汪峰", 28, JavaEightObject.Status.VOCATION),
                new JavaEightObject("李志", 20,JavaEightObject.Status.BUSY),
                new JavaEightObject("崔永元", 40, JavaEightObject.Status.VOCATION),
                new JavaEightObject("崔永元", 40, JavaEightObject.Status.FREE),
                new JavaEightObject("柴静", 18,JavaEightObject.Status.BUSY));

        System.out.println("*************** allMatch(Predicate p)  检查是否匹配所有元素");
        boolean allMatch = eightTerminate.stream()
                .allMatch(e -> e.getStatus().equals(JavaEightObject.Status.BUSY));
        System.out.println(allMatch);

        System.out.println("*************** anyMatch(Predicate p)  检查是否至少匹配一个元素");
        boolean anyMatch = eightTerminate.stream()
                .anyMatch(e -> e.getStatus().equals(JavaEightObject.Status.BUSY));
        System.out.println(anyMatch);


        System.out.println("noneMatch(Predicate p)  检查是否没有匹配所有元素");
        boolean noneMatch = eightTerminate.stream()
                .noneMatch(e -> e.getStatus().equals(JavaEightObject.Status.BUSY));
        System.out.println(noneMatch);


        System.out.println("findFirst()  返回第一个元素");
        Optional<JavaEightObject> first = eightTerminate.stream()
                .sorted(Comparator.comparing(JavaEightObject::getAge))
                .findFirst();
        System.out.println(first);

        System.out.println("findAny()    返回当前流中的任意元素");
        Optional<JavaEightObject> findAny = eightTerminate.stream()
                .filter(e -> e.getStatus().equals(JavaEightObject.Status.FREE))
                .findAny();
        System.out.println(findAny);

        System.out.println("count()      返回流中元素总数");
        Long count = eightTerminate.stream()
                .count();
        System.out.println(count);


        System.out.println("max(Comparator c)      返回流中最大值");
        Optional<JavaEightObject> max = eightTerminate.stream()
                .max(Comparator.comparing(JavaEightObject::getAge));
        System.out.println(max);

        System.out.println("min(Comparator c)      返回流中最小值");
        Optional<JavaEightObject> min = eightTerminate.stream()
                .min(Comparator.comparing(JavaEightObject::getAge));
        System.out.println(min);

        System.out.println("reduce(T iden, BinaryOperator b)     可以将流中元素反复结合起来，得到一个值。");
        Integer reduce = eightTerminate.stream()
                .map(JavaEightObject::getAge)
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        Optional<Integer> map_reduce = eightTerminate.stream()
                .map(JavaEightObject::getAge)
                .reduce(Integer::sum);
        System.out.println(map_reduce);

        System.out.println("toList  List<T>    把流中元素收集到List");
        List<String> nameList= eightTerminate.stream()
                .map(JavaEightObject::getName)
                .collect(toList());
        nameList.forEach(System.out::println);

        System.out.println("toSet  Set<T>      把流中元素收集到Set");
        Set<String> nameSet= eightTerminate.stream()
                .map(JavaEightObject::getName)
                .collect(Collectors.toSet());
        nameSet.forEach(System.out::println);


        System.out.println("toCollection    Collection<T>    把流中元素收集到创建的集合");
        HashSet<String> nameHashSet = eightTerminate.stream()
                .map(JavaEightObject::getName)
                .collect(Collectors.toCollection(HashSet::new));
        nameHashSet.forEach(System.out::println);


        System.out.println("counting  Long    计算流中元素的个数");
        Long eBoCountLong = eightTerminate.stream()
                .collect(Collectors.counting());
        System.out.println(eBoCountLong);


        System.out.println("summingInt  Integer    对流中元素的整数属性求和");
        Integer ageSum = eightTerminate.stream()
                .collect(Collectors.summingInt(JavaEightObject::getAge));
        System.out.println(ageSum);
        System.out.println("averagingInt  Double    计算流中元素Integer属性的平均值");
        Double ageAverage =  eightTerminate.stream()
                .collect(Collectors.averagingInt(JavaEightObject::getAge));
        System.out.println(ageAverage);
        System.out.println("summarizingInt  IntSummaryStatistics    收集流中Integer属性的统计值。");
        IntSummaryStatistics ageSummaryStatistics = eightTerminate.stream()
                .collect(Collectors.summarizingInt(JavaEightObject::getAge));
        System.out.println(ageSummaryStatistics);
        System.out.println("joining  String    连接流中每个字符串");
        String nameStringJoin = eightTerminate.stream()
                .map(JavaEightObject::getName)
                .collect(Collectors.joining(","));
        System.out.println(nameStringJoin);
        System.out.println("maxBy  Optional<T>    根据比较器选择最大值");
        Optional<JavaEightObject> maxBy = eightTerminate.stream()
                .collect(Collectors.maxBy(Comparator.comparing(JavaEightObject::getAge)));
        System.out.println(maxBy);
        System.out.println("minBy  Optional<T>    根据比较器选择最小值");
        Optional<JavaEightObject> minBy = eightTerminate.stream()
                .collect(Collectors.minBy(Comparator.comparing(JavaEightObject::getAge)));
        System.out.println(minBy);
        System.out.println("reducing 归约产生的类型    从一个作为累加器的初始值开始，利用BinaryOperator与流中元素逐个结合，从而归约成单个值");
        Integer ageCollectReduce = eightTerminate.stream()
                .map(JavaEightObject::getAge)
                .collect(Collectors.reducing(0, (x, y) -> x + y));
        System.out.println(ageCollectReduce);
        System.out.println("collectingAndThen  转换函数返回的类型    包裹另一个收集器，对其结果转换函数 ");
        List<JavaEightObject> objectsCollectingAndThen = eightTerminate.stream()
                .collect(Collectors.collectingAndThen(toList(), Collections::unmodifiableList));
        objectsCollectingAndThen.forEach(System.out::println);
        System.out.println("groupingBy Map<K, List<T>>    根据某属性值对流分组，属性为K，结果为V");
        Map<String, List<JavaEightObject>> nameMap = eightTerminate.stream()
                .collect(Collectors.groupingBy(JavaEightObject::getName));
        nameMap.forEach((name,list) -> {
            System.out.println(name + "-------" + StringUtils.join(",",list));
        });
        System.out.println("partitioningBy  Map<Boolean, List<T>>    根据true或false进行分区");
        Map<Boolean, List<JavaEightObject>> partitioningMap = eightTerminate.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 35));
        partitioningMap.forEach((name,list) -> {
            System.out.println(name + "-------" + StringUtils.join(",",list));
        });


    }












}

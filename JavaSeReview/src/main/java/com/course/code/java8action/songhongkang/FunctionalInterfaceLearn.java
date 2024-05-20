package com.course.code.java8action.songhongkang;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


/**
 * 函数式接口
 *     只包含一个抽象方法的接口，称为函数式接口.
 *     我们可以在任意函数式接口上使用 @FunctionalInterface 注解，这样做可以检查它是否是一个函数式接口，同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口。
 *
 * 四大内置函数式接口
 *     Consumer<T> 消费型接口    void accept(T t)
 *     Supplier<T> 供给型接口    T get()
 *     Function<T, R>函数型接口  R apply(T t);
 *     Predicate<T> 断定型接口   boolean test(T t);
 *
 */
public class FunctionalInterfaceLearn {

    @Test
    public void testFunctionalInterfaceOne() {

        // 将数平方
        Integer douRes = operaterNum(10, (x) -> x * x);
        System.out.println(douRes);

        // 加法
        Integer plusRes = operaterNum(10, (y) -> y + 20);
        System.out.println(plusRes);


    }

    public Integer operaterNum(Integer num,Myfun mf) {
        return mf.getValue(num);
    }

    // 带有泛型的接口
    @Test
    public void testFunctionalInterfaceTwo() {
        operateLong(10L,20L,(x,y) -> (Long) (x + y));
        operateLong(10L,20L,(x,y) -> (Long) (x * y));

    }

    public void operateLong(Long one,Long two, Myfun2<Long,Long> myfun2) {
        System.out.println(myfun2.getValue(one,two));
    }

    @Test
    public void testFunctionalInterfaceConsumer() {
        consumerE("abcde", x -> System.out.println("消费型接口处理s: " + x));

    }
    @Test
    public void testFunctionalInterfaceSupplier() {
        List<Integer> listRan = supplierE(5, () -> (int) (Math.random() * 10));
        for (Integer integer : listRan) {
            System.out.println(integer);
        }

    }

    @Test
    public void testFunctionalInterfaceFunction() {
        String functionE = functionE("abc", (x) -> x.toUpperCase());
        System.out.println(functionE);

    }

    @Test
    public void testFunctionalInterfacePredicate() {
        List<String> stringList = Arrays.asList("hello","world","ha","ele");
        List<String> listRes = predicateE(stringList, (x) -> x.length() >= 3);
        System.out.println(StringUtils.join("",listRes));
    }



    public void consumerE(String s, Consumer<String> consumer) {
        consumer.accept(s);
    }

    // 产生指定个数的数字放入集合
    public List<Integer> supplierE(Integer num, Supplier<Integer> supplier) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            res.add(n);
        }
        return res;
    }

    // 函数型接口的练习
    public String functionE(String x, Function<String,String> fu) {
        return fu.apply(x);
    }

    //判断型接口 将满足条件的字符串放入到集合中
    public List<String> predicateE(List<String> list, Predicate<String> predicate) {
        List<String> res = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                res.add(s);
            }
        }
        return res;
    }







}

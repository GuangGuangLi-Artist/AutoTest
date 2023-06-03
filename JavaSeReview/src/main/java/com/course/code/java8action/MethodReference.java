package com.course.code.java8action;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.mysql.cj.conf.RuntimeProperty;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * 方法推导
 *      方法推导的使用方式就是类后面加两个":"，再跟上要调用的方法名
 *
 *      1.A method reference to a static method (for example, the method parseInt of Integer, written Integer::parseInt)
 *      2.A method reference to an instance method of an arbitrary type (for example, the method length of a String, written String::length) 一个对象的方法也可以用推导，如描述中所举例的String对象的length方法
 *      3. A method reference to an instance method of an existing object (for example, suppose you have a local variable expensiveTransaction that holds an object of type Transaction, which supports an instance method getValue; you can write expensiveTransaction::getValue)
 *
 * Constructor references 构造函数方法推导
 *
 *
 *
 */
public class MethodReference {

    public static void main(String[] args) {
        Consumer listener = (s) -> System.out.println(s);
        useConsunmer(listener,"hello alice");
        System.out.println("------------");
        useConsunmer(s -> System.out.println(s),"hello alice");
        System.out.println("------------");

        //方法推导
        useConsunmer(System.out::println,"hello alice");
        System.out.println("------------");


        Consumer listener1 = (s) -> System.out.println(s);
        listener1.accept("hello alice");


        System.out.println("------------");

        Function<String, Integer> integerFunction = Integer::parseInt;
        Integer value = integerFunction.apply("123");
        System.out.println(value);
        System.out.println("------------");


        //一个对象的方法也可以用推导
        String var = "hello Object Method";
        BiFunction<String, Integer, Character> stringIntegerCharacterBiFunction = String::charAt;
        Character apply = stringIntegerCharacterBiFunction.apply(var, 3);
        System.out.println(apply);
        System.out.println("------------");

        //对象的方法推导
        Function<Integer, Character> characterFunction = var::charAt;
        Character character = characterFunction.apply(4);
        System.out.println(character);
        System.out.println("------------");


        //构造方法推导
        ThreeFunction<String,Long,String,ComplexApple> stringComplexAppleThreeFunction = ComplexApple::new;
        ComplexApple complexApple = stringComplexAppleThreeFunction.apply("red", 135L, "红富士");
        System.out.println(complexApple);

        System.out.println("------------");
        List<Apple> apples = Arrays.asList(new Apple("green",120),new Apple("red",130),new Apple("yellow",170),
                new Apple("green",160));
        apples.sort((a1,a2) -> a1.getColor().compareTo(a2.getColor()));
        System.out.println(apples);
        System.out.println("------------");

        apples.sort(Comparator.comparing(Apple::getColor));
        System.out.println(apples);


    }

    public static <T> void useConsunmer(Consumer<T> consumer, T t){
        consumer.accept(t);
        consumer.accept(t);
    }


}

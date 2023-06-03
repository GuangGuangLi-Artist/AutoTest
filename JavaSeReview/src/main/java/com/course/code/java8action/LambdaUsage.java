package com.course.code.java8action;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * 什么是functionalinterface
 *  有唯一一个抽象方法，也可以包含static和default的方法实现，像这样的接口就是具有functional的接口
 *  Predicate 传入一个值，最终返回的是一个boolean类型
 *      LongPredicate long类型参数
 *      IntPredicate int 类型参数
 *      BiPredicate 两个参数
 *      Predicate 任意类型参数
 *
 *  Consumer 接收的参数由自己定义对应的处理方法
 *  Function
 *
 *
 *
 *
 */
public class LambdaUsage {

    public static void main(String[] args) {

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello runnable1");
            }
        };

        Runnable runnable2 = () -> System.out.println("hello runnable2");

        process(runnable1);
        process(runnable2);
        process(() -> System.out.println("hello runnable3"));


        //Predicate 内部的实现方法返回为true的返回数据
        List<Apple> apples = Arrays.asList(new Apple("green",120),new Apple("red",130),new Apple("yellow",170),
                new Apple("green",160));

        //筛选出想要的苹果
        List<Apple> green_big = filterG_nd_W(apples, (c, w) -> c.equals("green") && w > 150);
        System.out.println(green_big);
        System.out.println("-------------");

        //Consumer 打印苹果
        printApple(apples,c -> System.out.println(c));
        System.out.println("-------------");

        //BiConsumer 打印苹果
        useBiConsumer("useBiConsumer",apples,(Apple a,String s) -> System.out.println( s + "_" + a.getColor() + ":" + a.getWeight()));
        System.out.println("-------------");

        //BiFunction 新建对象
        Apple apple = useBiFunction("blue", 135, (s, w) -> new Apple(s, w));
        System.out.println(apple);

        System.out.println("-------------");

        ///Supplier 新建对象
        Apple supplierCreateApple = useSupplier_createApple(() -> new Apple("green", 125));
        System.out.println(supplierCreateApple);
        System.out.println("-------------");

        //匿名内部类访问的变量必须是final类型 如果不是 则会报错
        //Variable used in lambda expression should be final or effectively final
        int i = 0;
        Runnable runnable_final = () -> System.out.println(i);
        runnable_final.run();
        //i++;




    }




    public static void process(Runnable runnable){
        if(runnable != null){
            runnable.run();
        }
    }


    //筛选出绿色的重量大于150的苹果
    public  static List<Apple> filterG_nd_W(List<Apple> apples, BiPredicate<String,Long> predicate){
        List<Apple> res = new ArrayList<>();
        for (Apple apple : apples) {
            if(predicate.test(apple.getColor(),apple.getWeight())){
                res.add(apple);
            }
        }
        return res;
    }

    // 使用Consumer 具体行为由我们自己定义
    public static void printApple(List<Apple> apples, Consumer<Apple> consumer){
        for (Apple apple : apples) {
            consumer.accept(apple);
        }
    }

    //使用BiConsumer 具体行为由我们自己定义
    public static void useBiConsumer(String prefix, List<Apple> apples, BiConsumer<Apple,String> consumer){
        for (Apple apple : apples) {
            consumer.accept(apple,prefix);
        }
    }


    //使用BiFunction
    public static Apple useBiFunction(String color, long weight, BiFunction<String,Long,Apple> biFunction){
        return biFunction.apply(color,weight);
    }

    // 使用Supplier

    public static Apple useSupplier_createApple(Supplier<Apple> supplier){
        return supplier.get();
    }


}

package com.course.code.java8action.songhongkang;

import org.testng.annotations.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 * （实现抽象方法的参数列表，必须与方法引用方法的参数列表保持一致！）
 *     对象::实例方法
 *     类::静态方法
 *     类::实例方法
 */
public class MethodReferences {

    @Test
    public void testMethodReferences() {
        System.out.println("*************** 对象::实例方法");
        List<String> strings = Arrays.asList("hello","world");
        strings.forEach( x -> System.out.println(x));
        System.out.println("***************");
        strings.forEach(System.out::println);
        System.out.println("***************");
        PrintStream printStream = System.out;
        Consumer <String> con = printStream::println;
        con.accept("abc");
        System.out.println("***************");
        Consumer listener = System.out::println;
        listener.accept("这也可以吗");
        System.out.println("***************");
        JavaEightObject je = new JavaEightObject("java8",23);
        Supplier<String> sc = je::getName;
        String name = sc.get();
        System.out.println(name);


        System.out.println("*************** 类::静态方法");
        BinaryOperator<Double> bo = Math::pow;
        Double aDouble = bo.apply(2d, 2d);
        System.out.println(aDouble);
        System.out.println("***************");
        Comparator<Integer> comparetets = Integer::compare;

        System.out.println(comparetets.compare(1,1));


    }



}

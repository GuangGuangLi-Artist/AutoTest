package com.course.code.java8action.songhongkang;

import org.testng.annotations.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

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

        System.out.println("*************** 类::实例方法");
        //注意：当需要引用方法的第一个参数是调用对象，并且第二个参数是需要引用方法的第二个参数(或无参数)时：ClassName::methodName
        BiPredicate<String,String> bp = (x,y) -> x.equals(y);
        boolean b = bp.test("abc", "abc");
        System.out.println(b);
        BiPredicate<String,String> bs = String::equals;
        boolean b1 = bs.test("abc", "abc");
        System.out.println(b1);


    }

    @Test
    public void testConstructor() {
        System.out.println("*************** 构造器引用");
        Function<Integer,JavaEightObject> je = (x) -> new JavaEightObject(x);
        JavaEightObject jeo = je.apply(10);
        System.out.println(jeo);
        System.out.println("*************** ClassName::new");
        // 注意： 需要调用得构造器得参数列表要与函数式接口中抽象方法得参数列表保持一致
        Function<Integer,JavaEightObject> jeobj = JavaEightObject::new;
        JavaEightObject jes = jeobj.apply(10);
        System.out.println(jes);

        System.out.println("*************** 数组引用");


    }

    @Test
    public void testArrayReference() {
        System.out.println("*************** 数组引用");
        Function<Integer,String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);
        System.out.println("*************** type[] :: new");
        Function<Integer,String[]> funType = String[]::new;
        String[] strL = funType.apply(15);
        System.out.println(strL.length);

    }



}

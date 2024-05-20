package com.course.code.java8action.songhongkang;

import org.testng.annotations.Test;

import java.util.Comparator;

public class LambdaTest {

    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("学习lambda表达式");
            }
        };
        runnable.run();

        System.out.println("****************************");

        Runnable runa = () -> System.out.println("这是lambda表达式写法");
        runa.run();

    }



    @Test
    public void test2() {
        Comparator<Integer> com1= new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare = com1.compare(1, 2);
        System.out.println(compare);

        System.out.println("****************************");

        Comparator<Integer> comparator = (o1,o2) -> Integer.compare(o1,02);
        int lambda1 = comparator.compare(1, 2);
        System.out.println(lambda1);

        System.out.println("方法引用");

        Comparator<Integer> comparatorFunc = Integer::compare;
        int compareFun = comparatorFunc.compare(1, 2);
        System.out.println(compareFun);
    }





}

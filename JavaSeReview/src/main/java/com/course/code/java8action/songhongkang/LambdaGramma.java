package com.course.code.java8action.songhongkang;


import org.testng.annotations.Test;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/**
 * Lambda 表达式语法
 *     ->左侧：指定了 Lambda 表达式需要的所有参数
 *     ->右侧：指定了 Lambda 体，即 Lambda 表达式要执行的功能。
 */
public class LambdaGramma {

    //语法格式一：无参，无返回值，Lambda 体只需一条语句
    @Test
    public void testLambdaGrammaOne() {
        Runnable runnable = () -> System.out.println("无参，无返回值的lambda表达式");
        runnable.run();

    }

    //语法格式二：Lambda 需要一个参数
    @Test
    public void testLambdaGrammaTwo() {
        Consumer<String> cs = (newStr) -> System.out.println("Lambda 需要一个参数 " + newStr);
        cs.accept("需要一个参数newStr");
    }

    //语法格式三：Lambda 只需要一个参数时，参数的小括号可以省略
    @Test
    public void testLambdaGrammaThree() {
        Consumer<String> cs = newStr -> System.out.println("Lambda 需要一个参数 " + newStr);
        cs.accept("一个参数时，参数的小括号可以省略");
    }

    //语法格式四：Lambda 需要两个参数，并且有返回值
    @Test
    public void testLambdaGrammaFour() {
        BinaryOperator<Integer> bo = (x,y) -> {
            System.out.println("Lambda 需要两个参数，并且有返回值");
            return  x + y;
        };
        Integer res = bo.apply(10, 20);
        System.out.println(res);
    }

    //语法格式五：当 Lambda 体只有一条语句时，return 与大括号可以省略
    @Test
    public void testLambdaGrammaFive() {
        BinaryOperator<Integer> bo = (x,y) ->  x + y;
        Integer res = bo.apply(10, 30);
        System.out.println(res);
    }

    //语法格式六：类型推断
    @Test
    public void testLambdaGrammaSix() {
        // x y 的数据类型为Integer 可根据编译器推断出类型 称为类型推断
        BinaryOperator<Integer> bo = (x,y) ->  x + y;
        Integer res = bo.apply(10, 30);
        System.out.println(res);
    }




}

package com.course.code.java8action;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTestCompose {

    public static void main(String[] args) {
        int i = computeComposeTest(2, value -> value * 3, value -> value * value);
        System.out.println(i);

        System.out.println("------------------");
        int andThen = computeAndThenTest(2, value -> value * 3, value -> value * value);
        System.out.println(andThen);

        System.out.println("------------------");
        String identify = computeIdentify("s", value -> "to_" + value);
        System.out.println(identify);

        System.out.println("------------------");
        int biFunctionTest1 = computeBiFunctionTest(2, 3, (Integer a, Integer b) -> a + b);
        System.out.println(biFunctionTest1);
        int biFunctionTest2 = computeBiFunctionTest(2, 3, (Integer a, Integer b) -> a * b);
        System.out.println(biFunctionTest2);
    }


    /**
     *
     * @param a
     * @param function1
     * @param function2
     * @return
     *
     * 对于输入参数，首先会执行compose参数中的函数 执行湾之后返回值为 2* 2
     * 接着function2执行的结果4作为function1的输入参数
     */
    private static int computeComposeTest(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.compose(function2).apply(a);
    }


    /**
     *
     * @param a
     * @param function1
     * @param function2
     * @return
     *
     * 对于输入参数，首先会执行function1函数 返回 2* 3
     * 然后将function1的结果作为参数传给function2
     */
    private static int computeAndThenTest(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.andThen(function2).apply(a);
    }


    private static String computeIdentify(String a ,Function<String,String> function){
        return function.apply(a);
    }

    private static int  computeBiFunctionTest(int a, int b, BiFunction<Integer,Integer,Integer> biFunction){
        return biFunction.apply(a,b);
    }



}

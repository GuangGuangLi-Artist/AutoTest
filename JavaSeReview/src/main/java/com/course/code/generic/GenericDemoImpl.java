package com.course.code.generic;

/**
 * 这是泛型类 实现泛型接口
 * 泛型类的格式为 ：public class 类名 <泛型类型>
 * @param <T>
 */

public class GenericDemoImpl<T> implements GenericDemo<T> {
    @Override
    public void printTonConsle(T t) {
        System.out.println(t);
    }

    @Override
    public <T1> T1 returnStr(T1 t1) {
        return t1;
    }
}

package com.course.code.generic;

/**
 * 这是一个泛型接口
 * 格式为 public interface 接口名<泛型类型>
 *
 * 接口中的抽象方法为泛型方法
 * 格式为:public <泛型类型> 返回类型 方法名(泛型类型)
 *
 */

public interface GenericDemo<T> {
    public abstract void printTonConsle(T t);


    public <T> T returnStr(T t);
}

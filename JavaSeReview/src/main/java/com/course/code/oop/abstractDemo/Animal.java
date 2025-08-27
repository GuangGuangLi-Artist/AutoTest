package com.course.code.oop.abstractDemo;

/**
 * 抽象方法 abstract
 */
abstract  class Animal {

    //抽象方法不能有方法体
//    abstract void eat(){};

    int num = 10;
    final int num2 = 20;

    public Animal() {};//有构造方法。但是不能实例化 用于子类访问父类数据的初始化

    public void method(){//也可以有非抽象方法 用于给子类直接使用，提高了代码的复用性
        System.out.println("Animal method");
    }


    abstract void eat();//可以有抽象方法  强制要求子类做某些事情。

}

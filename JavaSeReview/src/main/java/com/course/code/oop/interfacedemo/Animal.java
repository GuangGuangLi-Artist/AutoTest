package com.course.code.oop.interfacedemo;

/**
 * 	接口的特点：
 * 		A:接口用关键字interface表示
 * 			格式：interface 接口名 {}
 * 		B:类实现接口用implements表示
 * 			格式：class 类名 implements 接口名 {}
 * 		C:接口不能实例化
 * 			接口多态。
 * 		D:接口的子类
 * 			a:要么是抽象类
 * 			b:要么重写接口中的所有的抽象方法
 *  接口的成员特点：
 * 		A:成员变量
 * 			是常量，并且是静态的修饰的。
 * 			默认的修饰符：public static final
 * 		B:构造方法
 * 			没有构造方法
 * 		C:成员方法
 * 			只能是抽象方法。
 * 			默认的修饰符：public abstract
 *
 * 		建议：
 * 			自己写接口的内容的时候，把这些默认修饰符加上。
 * 	类与类：
 * 		继承关系，只能单继承。可以多层继承。
 * 	类与接口：
 * 		实现关系，可以单实现，也可以多实现。
 * 		还可以在继承一个类的同时实现多个接口。
 * 	接口与接口：
 * 		继承关系，可以单继承，也可以多继承。
 */
interface Animal {

    int num = 10;
    final int num2 = 20;
    public static final int num3 = 30;

    //public Animal(){};//没有构造方法


    //abstract void method(){};
    void method();
    abstract void show(); //只能是抽象方法。
}

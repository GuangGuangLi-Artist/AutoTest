package com.course.code.oop.duotai;


/**
 * 	多态：同一个对象在不同时刻表现出现的不同状态。
 *
 * 	举例：
 * 		A:水(水，冰，水蒸气)
 *
 * 		B:猫和动物。
 * 			把右边的值赋值给左边，如果能读通过，就说明可以。
 * 			动物 d = new 动物();
 * 			动物 dd = new 猫();
 * 			猫 m = new 猫();
 * 			猫 mm = new 动物();  错误
 *
 * 			动物 dd = new 猫();
 *
 * 	    代码如何体现呢?
 * 		    A:有继承关系
 * 		    B:有方法重写
 * 		    C:有父类引用指向子类对象
 * 	多态的成员访问特点：
 * 		A:成员变量
 * 			编译看左边，运行看左边。
 * 		B:成员方法
 * 			编译看左边，运行看右边。
 *
 * 			为什么呢?
 * 				因为成员方法有重写，而变量没有。
 * 		C:静态方法
 * 			编译看左边，运行看左边。
 *
 * 			静态方法其实没有重写这一说。因为它是跟类相关。
 */
public class Person {

    public String name = "人类";

    public void eat(){
        System.out.println("person eat");
    }

    public static void sleep(){
        System.out.println("person sleep");
    }
}

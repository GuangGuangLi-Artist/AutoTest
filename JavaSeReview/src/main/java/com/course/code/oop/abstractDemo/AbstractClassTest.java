package com.course.code.oop.abstractDemo;

public class AbstractClassTest {
    public static void main(String[] args) {

        //Animal animal = new Animal();//无法实例化
        //Dog d = new Dog();//无法实例化

        Cat cat = new Cat("fu");
        cat.eat();
        System.out.println("--------");

        Animal animal = new Cat("fufu");//多态
        animal.eat();
        System.out.println("--------");

        animal.method();
        System.out.println("--------");
        cat.method();
        System.out.println("--------");
        cat.show();
        System.out.println("--------");
        cat.function();


    }

}

package com.course.code.oop.interfacedemo;

public class Dog implements Animal{

    @Override
    public void method() {
        System.out.println("Dog method");

    }

    @Override
    public void show() {
       //num = 100;//Cannot assign a value to final variable 'num'
        System.out.println(num);
        System.out.println("---------");
        //num2 = 200;//Cannot assign a value to final variable 'num2'
        System.out.println(num2);
        System.out.println("---------");
        System.out.println(Animal.num);

    }
}

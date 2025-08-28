package com.course.code.oop.interfacedemo.interfaceUse;

public class Teacher extends Person {
    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    void study() {
        System.out.println("老师学习如何讲课");
    }
}

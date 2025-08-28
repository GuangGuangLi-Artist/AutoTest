package com.course.code.oop.interfacedemo.interfaceUse;

public class Student  extends Person{





    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    void study() {
        System.out.println("Student study");
    }
}

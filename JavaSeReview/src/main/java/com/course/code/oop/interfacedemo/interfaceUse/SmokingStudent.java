package com.course.code.oop.interfacedemo.interfaceUse;

public class SmokingStudent extends Student implements Smoking{

    public SmokingStudent() {
    }

    public SmokingStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public void smoking() {
        System.out.println("爱抽烟的学生");
    }
}

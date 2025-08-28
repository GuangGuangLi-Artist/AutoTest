package com.course.code.oop.interfacedemo.interfaceUse;

public class SmokingTeacher extends Teacher implements Smoking{

    public SmokingTeacher() {
    }

    public SmokingTeacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void smoking() {
        System.out.println("爱抽烟的老师");
    }
}

package com.course.code.oop.duotai;

public class NorthPerson extends Person{

    public String name="北方人";

    @Override
    public void eat() {
        System.out.println("North person eat noddles");
    }

    public static void  sleep() {
        System.out.println("North person sleep");
    }


}

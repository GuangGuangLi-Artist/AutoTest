package com.course.code.oop.duotai;

public class PersonDemo {
    public static void main(String[] args) {
        Person person = new Person();
        person.eat();

        System.out.println("---------");

        //多态
        Person person2 = new NorthPerson();
        person2.eat();
        System.out.println(person2.name);//人类
        Person.sleep();

    }
}

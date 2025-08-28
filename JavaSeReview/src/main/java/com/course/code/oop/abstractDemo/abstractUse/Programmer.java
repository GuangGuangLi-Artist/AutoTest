package com.course.code.oop.abstractDemo.abstractUse;

public class Programmer extends Employee{

    public Programmer(){}

    public Programmer(String name, String eid, int salary) {
        super(name, eid, salary);
    }

    @Override
    void work() {
        System.out.println("Programmer is codeing ");
    }
}

package com.course.code.oop.abstractDemo.abstractUse;

public class EmployeeTest {
    public static void main(String[] args) {

        Programmer programmer = new Programmer("zhangsan","1001",8000);
        programmer.work();
        programmer.show();

        System.out.println("-----------");


        Manager manager = new Manager();
        manager.setName("lisi");
        manager.setEid("1000");
        manager.setSalary(10000);
        manager.setBonus(2000);
        manager.work();
        manager.show();

        System.out.println("-----------");
        Employee e = new Manager("wangwu","1002",10008,1500);
        e.show();

    }
}

package com.course.code.oop.abstractDemo.abstractUse;

/**
 * 抽象类的案例
 * 假如我们在开发一个系统时需要对员工类进行设计，员工包含3个属性：姓名、工号以及工资。
 * 	经理也是员工，除了含有员工的属性外，另为还有一个奖金属性。
 * 	请使用继承的思想设计出员工类和经理类。要求类中提供必要的方法进行属性访问。
 *
 * 	员工类：
 * 		普通员工：
 * 			姓名、工号以及工资
 * 		经理：
 * 			姓名、工号以及工资，奖金
 */
abstract class Employee {
    private String name;
    private String eid;
    private int salary;

    public Employee(){};

    public Employee(String name, String eid, int salary) {
        this.name = name;
        this.eid = eid;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void show(){
        System.out.println(name + "--- " + eid + "--- " + salary);
    }

    abstract void work();
}

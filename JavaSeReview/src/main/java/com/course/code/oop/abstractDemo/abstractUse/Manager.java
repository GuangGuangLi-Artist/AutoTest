package com.course.code.oop.abstractDemo.abstractUse;

public class Manager extends Employee{

    private int bonus;


    public Manager() {
    }

    public Manager(String name, String eid, int salary, int bonus) {
        super(name, eid, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("经理的Bonus: " + bonus);
    }

    @Override
    void work() {
        System.out.println("manager talk with xiangmutouziren");
    }
}

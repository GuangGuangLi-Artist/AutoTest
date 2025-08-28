package com.course.code.oop.chongxiezai;

public class OverrideTes extends OverrideFa {

    /**
     * 方法覆盖是指子类重新实现父类中已经存在的方法，并且方法签名（方法名、参数列表）保持一致。
     * 方法覆盖发生在继承关系中，是运行时多态的一种体现，允许子类通过自己的实现覆盖父类的方法。
     */

    @Override
    public void sound() {
        System.out.println("this is overrideSon sound");
    }

    public static void main(String[] args) {
        OverrideTes t = new OverrideTes();
        t.sound();
    }
}

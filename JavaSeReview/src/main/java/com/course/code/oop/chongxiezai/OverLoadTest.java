package com.course.code.oop.chongxiezai;

public class OverLoadTest {


    /**
     * 方法重载：在同一个类中，多个方法具有相同的名字，但参数列表不同。方法重载是编译时多态的一种表现，它通过方法参数的不同来区分方法。
     * @param a
     * @param b
     * @return
     */

    public int overLoadMethod(int a, int b) {
        return a + b;
    }

    public double overLoadMethod(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        OverLoadTest test = new OverLoadTest();
        System.out.println(test.overLoadMethod(1, 2));
        System.out.println(test.overLoadMethod(2.1, 3.4));
    }
}

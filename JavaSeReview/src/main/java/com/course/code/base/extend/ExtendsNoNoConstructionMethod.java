package com.course.code.base.extend;

public class ExtendsNoNoConstructionMethod {
    public static void main(String[] args) {
        Son1 son1 = new Son1();
        System.out.println("====");
        Son1 ss = new Son1("wangeang");

    }
}

class Fu1 {


    //写一个带参构造，将默认给出的无参构造取消
    public Fu1(String name){
        System.out.println(name + "父类的带参构造");
    }

}

class Son1 extends Fu1{

    public Son1(){
        super("test");
        System.out.println("子类的无参构造");
    }


    public Son1(String name){
        //super("test");

        this();//调用了子类的无参构造
        System.out.println(name + "子类的带参构造");
    }
}

package com.course.code.base.extend;

public class ExtendsConstructionMethod {

    public static void main(String[] args) {
        Zi zi = new Zi();
        System.out.println("==========");
        Zi zi1 = new Zi("zhangsan");




    }
}



class Fu{

    public Fu(){
        System.out.println("父类的无参构造方法");
    }

    public Fu(String name){
        System.out.println("父类的带参构造方法");
    }

}

class Zi extends Fu{


    public Zi(){
        super();
        System.out.println("子类的无参构造方法");
    }

    public Zi(String name){
        //默认省略super()
        super();
        System.out.println("子类的带参构造方法");
    }
}


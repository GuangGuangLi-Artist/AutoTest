package com.course.code.deepshallowcopy;

import org.testng.asserts.Assertion;

/**
 * 浅拷贝：浅拷贝会在堆上创建一个新的对象（区别于引用拷贝的一点），不过，如果原对象内部的属性是引用类型的话，浅拷贝会直接复制内部对象的引用地址，也就是说拷贝对象和原对象共用同一个内部对象。
 * 深拷贝 ：深拷贝会完全复制整个对象，包括这个对象所包含的内部对象。
 */

public class ShallowCopy  implements Cloneable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShallowCopy(String name) {
        this.name = name;
    }

    public ShallowCopy clone(){

        try{
            return (ShallowCopy)super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }

    }
}

class Person implements Cloneable{

    private ShallowCopy shallowCopy;

    public Person(ShallowCopy shallowCopy) {
        this.shallowCopy = shallowCopy;
    }

    public ShallowCopy getShallowCopy() {
        return shallowCopy;
    }

    public void setShallowCopy(ShallowCopy shallowCopy) {
        this.shallowCopy = shallowCopy;
    }

    public Person clone(){
        try{
            Person person = (Person) super.clone();
            return  person;
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}

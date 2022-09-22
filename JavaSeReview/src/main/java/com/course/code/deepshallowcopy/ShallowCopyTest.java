package com.course.code.deepshallowcopy;

public class ShallowCopyTest {

    //测试浅拷贝
    public static void main(String[] args) {

        Person person1 = new Person(new ShallowCopy("浅拷贝"));

        Person personCopy = person1.clone();

        //从输出结构就可以看出， person1 的克隆对象和 person1 使用的仍然是同一个 Address 对象。
        System.out.println(person1.getShallowCopy() == personCopy.getShallowCopy());
    }
}

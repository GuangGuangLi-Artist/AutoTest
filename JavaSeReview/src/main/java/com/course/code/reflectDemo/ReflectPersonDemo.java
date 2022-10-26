package com.course.code.reflectDemo;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectPersonDemo {

    //测试反射

    @Test
    public void personReflectTest() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {

        //获取反射对象
        Class personClassReflect = Class.forName("com.course.code.reflectDemo.Person");

        //Constructor 构造器

        Constructor reflectConstructor = personClassReflect.getConstructor(String.class, int.class);
        //创建实例
        Person person = (Person) reflectConstructor.newInstance("li",23);


        //获取方法
        Method toStringMethod = personClassReflect.getMethod("toString");
        String res = (String) toStringMethod.invoke(person);
        System.out.println(res);

        Method eatMethod = personClassReflect.getMethod("eat");
        eatMethod.invoke(person);

        Method runMethod = personClassReflect.getDeclaredMethod("run");
        //设置私有成员可访问
        runMethod.setAccessible(true);
        runMethod.invoke(person);

        Person person1 = new Person("liguan",12);

        //获取成员变量
        Field nameField = personClassReflect.getDeclaredField("name");
        Field ageField = personClassReflect.getDeclaredField("age");

        nameField.setAccessible(true);
        ageField.setAccessible(true);

        String name = (String) nameField.get(person1);
        int age = (int) ageField.get(person1);
        System.out.println(name + "---" + age);

        //System.out.println(person);

    }
}

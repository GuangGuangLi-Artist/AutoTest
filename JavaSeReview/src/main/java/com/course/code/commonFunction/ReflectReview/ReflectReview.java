package com.course.code.commonFunction.ReflectReview;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 *   反射：就是通过class文件对象，去使用该文件中的成员变量，构造方法，成员方法。
 *
 *     Person p = new Person();
 *     p.使用
 *
 *     要想这样使用，首先你必须得到class文件对象，其实也就是得到Class类的对象。
 *     Class类：
 *             成员变量	Field
 *             构造方法	Constructor
 *             成员方法	Method
 *
 *     获取class文件对象的方式：
 *     A:Object类的getClass()方法
 *     B:数据类型的静态属性class
 *     C:Class类中的静态方法
 *             public static Class forName(String className)
 */
public class ReflectReview {

    @Test
    public void testReflectDemo1(){
        //Object类的getClass()方法
        ReflectReview obj1 = new ReflectReview();
        Class<? extends ReflectReview> aClass1 = obj1.getClass();

        ReflectReview obj2 = new ReflectReview();
        Class<? extends ReflectReview> aClass2 = obj2.getClass();

        System.out.println(obj1 == obj2);
        System.out.println(aClass1 == aClass2);

    }

    @Test
    public void testReflectDemo2(){
        //数据类型的静态属性class
        Class<ReflectReview> reviewClass = ReflectReview.class;
        System.out.println(int.class);
        System.out.println(reviewClass);//class com.course.code.commonFunction.ReflectReview.ReflectReview
    }

    @Test
    public void testReflectDemo3(){
        Class<?> forNameClass = null;
        try {
            forNameClass = Class.forName("com.course.code.commonFunction.ReflectReview.PersonReflect");
            System.out.println(forNameClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReflectDemo4(){
        //获取构造方法并使用
        Class<?> forNameClass = null;
        try {
            forNameClass = Class.forName("com.course.code.commonFunction.ReflectReview.PersonReflect");
            //获取所有构造方法
            Constructor<?>[] constructors = forNameClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            System.out.println("-------------");
            //获取单个构造方法 无参构造
            Constructor<?> single = forNameClass.getConstructor();//com.course.code.commonFunction.ReflectReview.PersonReflect()
            System.out.println(single);
            System.out.println("-------------");

            //使用无参构造创建对象
            PersonReflect noPara = (PersonReflect)single.newInstance();
            noPara.show();

            System.out.println("-------------");

            //通过反射去获取该构造方法并使用
            Constructor<?> havaPara = forNameClass.getConstructor(String.class, int.class, String.class);
            PersonReflect personHava = (PersonReflect) havaPara.newInstance("li", 22, "xixi");
            System.out.println(personHava);
            System.out.println("-------------");

            //通过反射获取私有构造方法并使用
            Constructor privateConstructor = forNameClass.getDeclaredConstructor(String.class);
            //该私有构造方法创建对象
            privateConstructor.setAccessible(true);//值为true则指示反射的对象在使用时应该取消Java语言访问检查。
            PersonReflect personPrivate = (PersonReflect) privateConstructor.newInstance("li");
            System.out.println(personPrivate);
            System.out.println("-------------");

            //获取所有的成员变量
            Field[] fields = forNameClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            System.out.println("-------------");

            //通过无参构造创建对象
            Constructor c4 = forNameClass.getConstructor();
            PersonReflect instace4 = (PersonReflect)c4.newInstance();
            //获取成员变量
            Field genderField = forNameClass.getField("gender");
            genderField.set(instace4,"男");
            System.out.println(instace4);

            //获取私有修饰的成员变量
            Field namePrivate = forNameClass.getDeclaredField("name");
            namePrivate.setAccessible(true);//设置暴力访问
            namePrivate.set(instace4,"这是私有");
            System.out.println(instace4);

            //获取默认修饰的age
            Field ageDefault = forNameClass.getDeclaredField("age");
            ageDefault.set(instace4,15);
            System.out.println(instace4);

            System.out.println("-------------");

            //获取所有的方法
            Method[] allMethods = forNameClass.getDeclaredMethods();
            for (Method allMethod : allMethods) {
                System.out.println(allMethod);

            }
            System.out.println("-------------");

            //获取无参方法
            Method methodShow = forNameClass.getMethod("method", String.class);
            methodShow.invoke(instace4, "这是有参数无返回值");


            System.out.println("-------------");

            //获取带参方法有返回值
            Method methodGetString = forNameClass.getMethod("getString", String.class, int.class);
            Object objectReturn = methodGetString.invoke(instace4, "这是带参数有返回", 123);
            System.out.println(objectReturn);
            System.out.println("-------------");
            //获取私有方法
            Method privateFunctionMethod = forNameClass.getDeclaredMethod("function");
            privateFunctionMethod.setAccessible(true);//暴力访问
            privateFunctionMethod.invoke(instace4);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

}

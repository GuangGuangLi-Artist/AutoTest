package com.course.code.commonFunction.annotation.refle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Sign(className = "com.course.code.commonFunction.annotation.refle.Cat",methodName = "eat")
public class SignTest {
    public static void main(String[] args) {
        Class<SignTest> signTest = null;
        try {
            //获取该类的类对象
            signTest = (Class<SignTest>) Class.forName("com.course.code.commonFunction.annotation.refle.SignTest");
            //获取类对象中的注解对象
            //原理实际上是在内存中生成了一个注解接口的子类实现对象
            Sign sign = signTest.getAnnotation(Sign.class);
            //调用注解对象中定义的抽象方法（注解中的属性）来获取返回值
            String className = sign.className();
            String methodName = sign.methodName();
            System.out.println(className + "---------" + methodName);

            Class<?> catClassName = Class.forName(className);
            Object object = null;

            try {
                object = catClassName.newInstance();
                Method method = catClassName.getMethod(methodName);
                method.invoke(object);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

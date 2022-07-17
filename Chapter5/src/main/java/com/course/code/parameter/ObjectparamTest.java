package com.course.code.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ObjectparamTest {

    @Test(dataProvider = "providerData")
    public void testObjectparamTest(String name,int age){
        System.out.println("name=" + name + ";age=" + age );

    }

    @DataProvider(name="providerData")
    public Object[] [] providerData(){

        Object[][] objects = new Object[][]{
                {"苏表",10},
                {"chengcheng",20},
                {"sufei",10},

        };
        return objects;
    }





    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1方法：" + "name=" + name + "; age=" + age );
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2方法：" + "name=" + name + "; age=" + age );

    }

    @DataProvider(name="methodData")
    public Object[] [] methodDataTest(Method method) {

        Object[][] objects = null;
        if (method.getName().equals("test1")) {
            objects = new Object[][]{
                    {"苏表1", 10},
                    {"chengcheng1", 20},
                    {"sufei1", 10},
            };
        } else if ( method.getName().equals("test2")){

                objects = new Object[][]{
                        {"苏表2", 10},
                        {"chengcheng2", 20},
                        {"sufei2", 10},
                };

        }
        return objects;

    }
}

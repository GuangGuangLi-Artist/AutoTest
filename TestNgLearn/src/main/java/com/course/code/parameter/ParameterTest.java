package com.course.code.parameter;

import org.testng.annotations.*;

public class ParameterTest {

    @Test
    @Parameters({"name","age"})
    public void ParamTest1(String name,int age){
        System.out.println("name=" + name + ";age=" + age );
    }

    @Test
    @Parameters({"sname","sage"})
    public void ParamTest2(String name,String age){
        System.out.println("name=" + name + ";age=" + age );
    }

    @BeforeClass
    @Parameters({"className", "method"})
    public void beforeParamTest(String className, String method) {
        System.out.println("className=" + className + ";method=" + method);
    }


    @BeforeMethod
    @Parameters({"methodName", "test"})
    public void beforeMethodTest(String methodName, String test) {
        System.out.println("methodName=" + methodName + ";test=" + test);
    }
}

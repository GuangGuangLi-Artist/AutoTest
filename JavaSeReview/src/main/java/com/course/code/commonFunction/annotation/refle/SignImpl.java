package com.course.code.commonFunction.annotation.refle;


import java.lang.annotation.Annotation;

public class SignImpl implements Sign{

    public String className() {
        return "com.course.code.commonFunction.annotation.refle.Cat";
    }


    public String methodName() {
        return "eat";
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}

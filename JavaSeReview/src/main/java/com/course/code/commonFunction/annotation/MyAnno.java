package com.course.code.commonFunction.annotation;


/**
 * 自定义注解
 *
 */
public @interface MyAnno {

    //基本数据类型
    int num();

    //字符串
    String val();

    //枚举
    Lamp lamp();

    //注解类型
    MyAnno2 myAnno2();

    //以上类型的数组
    String[] values();
    Lamp[] lamps();
    MyAnno2[] myAnno2s();
    int[] numbers();
}

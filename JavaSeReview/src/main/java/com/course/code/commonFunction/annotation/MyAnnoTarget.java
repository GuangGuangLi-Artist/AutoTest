package com.course.code.commonFunction.annotation;

import java.lang.annotation.*;

/**
 * Retention 生命周期
 * Target 指定被修饰的注解的作用范围。其作用范围可以在源码中找到参数值。FIELD（常用）METHOD（常用）	TYPE（常用）
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE,ElementType.FIELD, ElementType.PARAMETER,ElementType.ANNOTATION_TYPE,ElementType.PACKAGE})
@Inherited
public @interface MyAnnoTarget {

    String value();
}

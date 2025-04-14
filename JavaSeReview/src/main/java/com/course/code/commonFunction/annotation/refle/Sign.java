package com.course.code.commonFunction.annotation.refle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用反射机制解析注解
 *
 * 描述需要执行的类名和方法名
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Sign {
    String className();
    String methodName();
}

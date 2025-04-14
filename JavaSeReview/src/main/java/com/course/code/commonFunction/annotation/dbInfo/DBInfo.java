package com.course.code.commonFunction.annotation.dbInfo;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBInfo {
    String driver() default "com.mysql.jdbc.Driver";
    String url() default "jdbc:mysql://localhost:3306/pinyougoudb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    String username() default "root";
    String password() default "123456";
}

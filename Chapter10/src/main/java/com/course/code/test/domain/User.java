package com.course.code.test.domain;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private int age;
    private String sex;
    private String permission;
    private String isDelete;


}

package com.course.code.domain;

public class MocoPostCase {

    private String name;
    private  String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MocoPostCase{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

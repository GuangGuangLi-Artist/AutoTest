package com.course.code.domain;

public class MocoLoginCase {
    private String name;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MocoLoginCase{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

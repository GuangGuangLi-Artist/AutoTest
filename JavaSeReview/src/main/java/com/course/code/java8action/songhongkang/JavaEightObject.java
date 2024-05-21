package com.course.code.java8action.songhongkang;

import java.util.Objects;

public class JavaEightObject {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public JavaEightObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public JavaEightObject(int age) {
        this.age = age;
    }

    public JavaEightObject() {
    }

    @Override
    public String toString() {
        return "JavaEightObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaEightObject)) return false;
        JavaEightObject that = (JavaEightObject) o;
        return age == that.age && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

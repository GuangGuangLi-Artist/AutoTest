package com.course.code.commonFunction.ReflectReview;

public class PersonReflect {

    private String name;
    int age;
    public String gender;

    public PersonReflect() {
    }

    private PersonReflect(String name) {
        this.name = name;
    }

    PersonReflect(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PersonReflect(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //无参
    public void show() {
        System.out.println("show");
    }

    //带参
    public void method(String name) {
        System.out.println("method" + name);
    }

    //私有
    private void function() {
        System.out.println("function");
    }

    @Override
    public String toString() {
        return "PersonReflect{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

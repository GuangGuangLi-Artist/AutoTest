package com.course.code.domain;

public class GetUserListCase {
    private int id;
    private String userName;
    private String age;
    private String sex;

    @Override
    public String toString() {
        return "GetUserListCase{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", expected='" + expected + '\'' +
                '}';
    }

    private String expected;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }
}

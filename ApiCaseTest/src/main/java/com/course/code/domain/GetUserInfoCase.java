package com.course.code.domain;

public class GetUserInfoCase {

    private int id;
    private int userId;
    private String expected;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    @Override
    public String toString() {
        return "GetUserInfoCase{" +
                "id=" + id +
                ", userId=" + userId +
                ", expected='" + expected + '\'' +
                '}';
    }
}

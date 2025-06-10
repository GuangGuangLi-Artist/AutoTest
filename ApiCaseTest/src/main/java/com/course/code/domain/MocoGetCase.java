package com.course.code.domain;

public class MocoGetCase {
    private String name;
    private String password;
    private String postType;

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

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }


    @Override
    public String toString() {
        return "MocoGetCase{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", postType='" + postType + '\'' +
                '}';
    }
}

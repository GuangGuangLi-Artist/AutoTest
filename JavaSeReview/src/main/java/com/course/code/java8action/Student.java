package com.course.code.java8action;

public class Student {
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    //学生成绩升序
    public static int compareStudentByScore(Student student1,Student student2){
        return student1.getScore() - student2.getScore();
    }

    //名字升序
    public static int compareStudentByName(Student student1,Student student2){
        return student1.getName().compareTo(student2.getName());
    }

    //改造旧方法
    public int noStaticByScore(Student student){
        return  this.getScore() - student.getScore();
    }

    public int noStaticByName(Student student){
        return  this.getName().compareTo(student.getName());
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


}

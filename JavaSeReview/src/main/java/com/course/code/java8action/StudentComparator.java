package com.course.code.java8action;

public class StudentComparator {


    public int studentCompareByScore(Student s1,Student s2){
        return s1.getScore() - s2.getScore();
    }

    public int studentCompareByName(Student s1,Student s2){
        return s1.getName().compareTo(s2.getName());
    }
}

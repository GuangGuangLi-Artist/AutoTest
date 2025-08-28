package com.course.code.oop.interfacedemo.interfaceUse;

public class PersonTest {
    public static void main(String[] args) {
        SmokingStudent smokingStudent = new SmokingStudent();
        smokingStudent.setName("王德峰");
        smokingStudent.setAge(22);

        smokingStudent.study();
        smokingStudent.smoking();
        smokingStudent.sleep();
    }
}

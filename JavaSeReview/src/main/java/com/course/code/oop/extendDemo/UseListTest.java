package com.course.code.oop.extendDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UseListTest {
    public static void main(String[] args) {
        UseList ulist = new UseList();
        List<Integer> testList = Arrays.asList(1,2,3,4,5);

        //子类可以复用父类的方法
        ulist.reverseList1(testList);
        System.out.println(testList);


        System.out.println(ulist.getListSize(testList));





    }
}

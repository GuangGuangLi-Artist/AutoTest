package com.course.code.oop.extendDemo;



import java.util.Collections;
import java.util.List;

import static java.util.Collections.reverse;

public class BaseClass {

    protected List<Integer> lists;

    public BaseClass() {}
    public BaseClass(List<Integer> list) {
        this.lists = list;
    }

    public void reverseList1(List<Integer> lists) {
         Collections.reverse(lists);
    }
}

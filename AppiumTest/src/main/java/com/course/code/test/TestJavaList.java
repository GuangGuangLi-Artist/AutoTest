package com.course.code.test;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestJavaList {

    @Test
    public void testJavaLs() {
        List<List<Object>> lst = new ArrayList<List<Object>>();
        List<Object> obs1 = new ArrayList<>();
        List<Object> obs2 = new ArrayList<>();
        obs1.add("li");
        obs1.add("zhang");
        obs1.add(3);
        obs2.add("he");
        obs2.add("hong");
        lst.add(obs2);
        lst.add(0,obs1);
        for (List<Object> l : lst) {
            for (Object o : l) {
                System.out.println(o.toString());
            }
        }

    }
}

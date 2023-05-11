package com.course.code.functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaLearn {


    public static void main(String[] args) {
        String[] array = {"Apple","Orange","Bananana","Lemon"};

        //方法引用
        Arrays.sort(array,LambdaLearn::cmp);
        System.out.println(String.join(", ",array));//Apple, Bananana, Lemon, Orange

        System.out.println("=============");


        Arrays.sort(array,String::compareTo);
        System.out.println(String.join(", ",array));


        //构造方法引用

        List<String> names = List.of("Bob","Alice","Tim");
        List<LPerson> persons = new ArrayList<>();
        for(String name: names){
            persons.add(new LPerson(name));
        }

        System.out.println(persons);







    }


    static int cmp(String s1,String s2){
        return s1.compareTo(s2);
    }


}

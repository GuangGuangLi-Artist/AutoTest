package com.course.code.java8action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 方法引用
 * 其实我们可以将方法引用看作是一个函数指针【function pointer】
 */
public class MethodReference_1 {

    private String getString(Supplier<String> supplier){
        return supplier.get() + "test";
    }

    private String getString2(String str, Function<String,String> function){
       return function.apply(str);
    }






    public static void main(String[] args) {
        //类名::静态方法名
        ArrayList<Student> studentsList = new ArrayList<>();
        Student s1 = new Student("zhangdan",10);
        Student s2 = new Student("lisi",90);
        Student s3 = new Student("wangwu",50);
        Student s4 = new Student("zhaoliu",40);
        studentsList.add(s1);
        studentsList.add(s2);
        studentsList.add(s3);
        studentsList.add(s4);

        //排序
//        studentsList.sort((Student stu1, Student stu2) -> Student.compareStudentByScore(stu1,stu2));
//        studentsList.forEach(student -> System.out.println(student));

        System.out.println("update 上述代码");
        //1类名::静态方法名 为什么可以替代上面的写法 因为Comparator需要接受两个参数病返回一个整形 compareStudentByScore 这个完全满足接口的需求public interface Comparator<T> {int compare(T o1, T o2);}

        //其实对于方法引用的使用是有一个要求的：你所使用的Lambda表达式的方法体恰好有一个匹配的方法完成相同的功能，
        // 这时候就可以将Lambda表达式替换成方法引用，除此之外是无法用方法引用替换Lambda表达式的，所以说Lambda表达式是一种更为通用的方式，而方法引用是需要满足一定的条件才能够使用的。
        studentsList.sort(Student::compareStudentByScore);
        studentsList.forEach(System.out::println);
        System.out.println("---------------");

        studentsList.sort(Student::compareStudentByName);
        studentsList.forEach(System.out::println);
        System.out.println("---------------");

       //2引用名【对象名】::实例方法名

//        StudentComparator studentComparator = new StudentComparator();
//        studentsList.sort((st1,st2) -> studentComparator.studentCompareByScore(st1,st2));
//        studentsList.forEach(student -> System.out.println(student));
        System.out.println("update 上述代码");

        StudentComparator studentComparator = new StudentComparator();
        studentsList.sort(studentComparator::studentCompareByScore);
        studentsList.forEach(student -> System.out.println(student));
        System.out.println("---------------");

        studentsList.sort(studentComparator::studentCompareByName);
        studentsList.forEach(student -> System.out.println(student));
        System.out.println("---------------");

        //3类名::实例方法名

        studentsList.sort(Student::noStaticByScore);
        studentsList.forEach(student -> System.out.println(student));
        System.out.println("---------------");

        List<String> cities = Arrays.asList("qingdao","chongqing","tianjing","beijing");
        Collections.sort(cities,String::compareToIgnoreCase);
        cities.forEach(System.out::println);
        System.out.println("---------------");

        //4 类名::new
        MethodReference_1 m1 = new MethodReference_1();
        System.out.println(m1.getString(String::new));
        System.out.println("---------------");
        System.out.println(m1.getString2("hello",String::new));
        System.out.println("---------------");


        //默认方法  default method

        //实现类的优先级要比接口的优先级要更高一些












    }
}

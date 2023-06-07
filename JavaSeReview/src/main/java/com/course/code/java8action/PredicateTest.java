package com.course.code.java8action;

import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("zhangzan",12),new Person("lisi",13),
        new Person("wangwu",16),new Person("zhaoliu",26));

        List<Person> personByName = getPersonByName("zhangzan", personList);
        //System.out.println(personByName);
        personByName.forEach(person -> System.out.println(person.getName()));
        System.out.println("-----------");
        List<Person> byAge = getPersonByAge(13, personList);
        byAge.forEach(person -> System.out.println(person.getName()));
        System.out.println("-----------");

        List<Person> personByAgeUp = getPersonByAgeUp(12, personList, (ageofPerson, pList) -> pList.stream().filter(person -> person.getAge() > ageofPerson).collect(Collectors.toList()));
        personByAgeUp.forEach(person -> System.out.println(person.getName()));


        System.out.println("-----------");

        //Predicate  用于判断真假
        Predicate<String> predicateTest = p -> p.equals("HelloWorld");
        System.out.println(predicateTest.test("helloWorld"));
        Predicate<String> stringBooleanFunction = (String p) -> p.length() > 5;
        System.out.println(stringBooleanFunction.test("Hello World"));

        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //过滤奇数 偶数 大于5 小于3
        List<Integer> numOu = getNumByEachConditionPredicate(integerList, integer -> integer % 2 == 0);
        System.out.println(numOu);

        List<Integer> numji = getNumByEachConditionPredicate(integerList, integer -> integer % 2 != 0);
        System.out.println(numji);

        List<Integer> numgt= getNumByEachConditionPredicate(integerList, integer -> integer >5 );
        System.out.println(numgt);

        List<Integer> numlt= getNumByEachConditionPredicate(integerList, integer -> integer <3 );
        System.out.println(numlt);

        List<Integer> numAall= getNumByEachConditionPredicate(integerList, integer -> true );
        System.out.println(numAall);



    }


    private static List<Person> getPersonByName(String name, List<Person> pList){
        return  pList.stream().filter(person -> person.getName().equals(name))
                .collect(Collectors.toList());
    }

    private static List<Person> getPersonByAge(int age, List<Person> pList){
        /**
         * Integer 第一个参数
         * List<Person> 第二个参数
         * List<Person> 结果参数
         */
        BiFunction<Integer,List<Person>,List<Person>> biFunction = (ageofPerson,personList) ->{
            return personList.stream().filter(person -> person.getAge() > ageofPerson)
                    .collect(Collectors.toList());
        };
        //传入两个参数  返回一个结果
        return biFunction.apply(age,pList);
    }

    private static List<Person> getPersonByAgeUp(int age, List<Person> pList,BiFunction<Integer,List<Person>,List<Person>> biFunction){
        return biFunction.apply(age,pList);
    }

    private static List<Integer> getNumByEachConditionPredicate(List<Integer> integerList,Predicate<Integer> predicate){
        List<Integer> nums = new ArrayList<>();
        for (Integer integer: integerList){
            if(predicate.test(integer)){
                nums.add(integer);
            }
        }
        return nums;
    }


}

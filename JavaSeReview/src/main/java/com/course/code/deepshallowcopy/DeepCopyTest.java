package com.course.code.deepshallowcopy;

public class DeepCopyTest {

    public static void main(String[] args) {
        PersonDeep personDeep = new PersonDeep(new DeepCopy("深拷贝"));
        PersonDeep personDeep2 = personDeep.clone();
        System.out.println(personDeep.getDeepCopy()==personDeep2.getDeepCopy());
    }


}

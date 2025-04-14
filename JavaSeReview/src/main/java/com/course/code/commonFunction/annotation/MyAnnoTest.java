package com.course.code.commonFunction.annotation;

@MyAnno(num = 1,val = "这是注解测试",lamp = Lamp.RED,myAnno2 = @MyAnno2,values = {"t","e"},lamps = {Lamp.BLUE,Lamp.RED},myAnno2s = {@MyAnno2},numbers = {1,2})
public class MyAnnoTest {
    public static void main(String[] args) {
        System.out.println("测试注解");
    }
}

package com.course.code.commonFunction.ThreadRev;

public class ThreadRunableImlTest {

    public static void main(String[] args) {
        ThreadRunableIml threadRunableIml1 = new ThreadRunableIml();
        ThreadRunableIml threadRunableIml2 = new ThreadRunableIml();
        ThreadRunableIml threadRunableIml3 = new ThreadRunableIml();

        Thread thread1 = new Thread(threadRunableIml1,"zhangsan");
        Thread thread2 = new Thread(threadRunableIml2,"lisi");
        Thread thread3 = new Thread(threadRunableIml3,"wangwu");


        thread1.start();
        thread2.start();
        thread3.start();
    }


}

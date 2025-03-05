package com.course.code.multithreading;

import org.testng.annotations.Test;

public class MultithreadingTest1 {


    @Test(invocationCount = 10,threadPoolSize = 3)
    public void testmultithreading(){
        System.out.println("1");
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }
}

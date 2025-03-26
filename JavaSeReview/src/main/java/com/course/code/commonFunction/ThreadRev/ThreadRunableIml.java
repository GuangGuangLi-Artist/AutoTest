package com.course.code.commonFunction.ThreadRev;

public class ThreadRunableIml implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }

    }
}

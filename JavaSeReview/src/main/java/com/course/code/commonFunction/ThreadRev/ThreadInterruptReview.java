package com.course.code.commonFunction.ThreadRev;

public class ThreadInterruptReview {

    public static void main(String[] args) {
        ThreadInterrupt myThread1 = new ThreadInterrupt("关羽");
        ThreadInterrupt myThread2 = new ThreadInterrupt("张飞");
        ThreadInterrupt myThread3 = new ThreadInterrupt("刘备");

        myThread1.start();
//        myThread2.start();
//        myThread3.start();

        try {
            Thread.sleep(1000);
            myThread1.interrupt();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

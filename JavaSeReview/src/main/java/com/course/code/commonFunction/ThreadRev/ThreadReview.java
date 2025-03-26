package com.course.code.commonFunction.ThreadRev;

/**
 *
 */

public class ThreadReview {

    public static void main(String[] args) {

        MyThread myThread1 = new MyThread("张三");
        MyThread myThread2 = new MyThread("李三");
        MyThread myThread3 = new MyThread("王三");
        System.out.println(Thread.currentThread().getName());


        //设置线程优先级
        myThread1.setPriority(Thread.MIN_PRIORITY);
        myThread2.setPriority(Thread.MAX_PRIORITY);
        myThread3.setPriority(Thread.NORM_PRIORITY);


        myThread1.start();
        myThread2.start();
        myThread3.start();

        //获取线程优先级
        System.out.println(myThread1.getPriority());
        System.out.println(myThread2.getPriority());
        System.out.println(myThread3.getPriority());





    }




}

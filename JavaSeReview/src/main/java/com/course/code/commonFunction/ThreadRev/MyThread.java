package com.course.code.commonFunction.ThreadRev;

public class MyThread extends Thread{

    //继承Thread
    public MyThread(){}

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for (int i = 0; i < 200; i++) {
            System.out.println(getName() + " : " + i);
        }

    }



}

package com.course.code.commonFunction.ThreadRev;

import java.util.Date;

public class ThreadInterrupt extends Thread{
    public ThreadInterrupt(){
        super();
    }

    public  ThreadInterrupt(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("开始执行:" + new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("线程被终止了");
            }


        }
        System.out.println("结束执行:" + new Date());
    }
}

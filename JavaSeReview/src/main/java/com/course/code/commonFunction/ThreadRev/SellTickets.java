package com.course.code.commonFunction.ThreadRev;

public class SellTickets implements Runnable {
    private int ticket = 100;

    //创建锁对象
    Object object = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (object) {

                if (ticket > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + "正在卖出第" + (ticket--) + " 张票");

                }

            }
        }

    }
}

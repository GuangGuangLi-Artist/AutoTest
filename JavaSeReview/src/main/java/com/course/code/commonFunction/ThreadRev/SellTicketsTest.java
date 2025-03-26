package com.course.code.commonFunction.ThreadRev;

public class SellTicketsTest {

    public static void main(String[] args) {
        SellTickets sellTickets = new SellTickets();

        Thread thread1 = new Thread(sellTickets,"窗口1");
        Thread threa2 = new Thread(sellTickets,"窗口3");
        Thread threa3 = new Thread(sellTickets,"窗口3");

        thread1.start();
        threa2.start();
        threa3.start();
    }






}

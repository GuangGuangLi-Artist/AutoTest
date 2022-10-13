package com.course.code.oneOne;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class OneStdDraw {
    public static void main(String[] args) {
        StdOut.println("----开始使用库StdDraw----");
        //StdDraw.line(10,10,50,50);
        //StdDraw.circle(10,10,5);

        int n = 100;
        StdDraw.setXscale(0,n);
        StdDraw.setYscale(0,n*n);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= n; i++) {
            StdDraw.point(i,i);
            StdDraw.point(i,i*i);
            StdDraw.point(i,i*Math.log(i));
        }
    }
}

package com.course.code.oneThree;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 背包案例
 * 样本标准差：每个值和平均值之差的平方之和除以N-1之后的平方根
 *
 *
 */
public class Stats {

    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        while (!StdIn.isEmpty()){
            numbers.add(StdIn.readDouble());
        }

        int n = numbers.size();

        double sum = 0.0;
        for (double x: numbers){
            sum += x;
        }
        double mean = sum / n;

        sum = 0.0;
        for (double x: numbers){
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum/(n-1));

        StdOut.printf("mean: %.2f\n", mean);
        StdOut.printf("std dev: %.2f\n", std);

    }
}

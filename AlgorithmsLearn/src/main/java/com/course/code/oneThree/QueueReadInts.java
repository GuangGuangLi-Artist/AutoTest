package com.course.code.oneThree;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import org.testng.annotations.Test;

/**
 * 队列经典操作
 * 将文件读取到的数据按照先后顺序存放到列表，
 */
public class QueueReadInts {

    @Test
    public void testReadInts(){
        int[] ints = QueueReadInts.readInts("src/main/java/com/course/code/oneThree/readIntstext");
        for (int i = 0; i < ints.length; i++) {
            if(i+1==(ints.length)){
                StdOut.print(ints[i]);
            }else {
                StdOut.print(ints[i] + ",");
            }

        }
    }

    public static int[] readInts(String name){
        In in = new In(name);
        Queue<Integer> queue = new Queue<>();
        while (!in.isEmpty()){
            queue.enqueue(in.readInt()); //按照顺序读取文件中的数据到队列
        }
        int nums = queue.size();
        int [] a = new int[nums];//定义一个和队列相等长度的数组
        for (int i = 0; i < nums; i++) {
            a[i] = queue.dequeue();//将队列中的数据按照先后顺序读入到int数组
        }
        return  a;
    }
}

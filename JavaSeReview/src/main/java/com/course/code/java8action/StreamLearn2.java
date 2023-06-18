package com.course.code.java8action;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class StreamLearn2 {


    //并发流

    @Test
    public void testParalleStream(){
        //并发流
        List<String> uuIdList = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            uuIdList.add(UUID.randomUUID().toString());
        }

        System.out.println("开始排序");

        long startTime = System.nanoTime();
        uuIdList.parallelStream().sorted().count();//自然排序 之所以写count是因为流中必须得有一个终止操作才能结束中间操作
        long endTime = System.nanoTime();
        long milles = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("排序耗时:" + milles);

    }
}

package com.course.code.cases.group;

import org.testng.annotations.Test;

public class ClassCard2 {

    @Test(groups = "driver")
    public void testClassCard2DriverGroup() {
        System.out.println("这是ClassCard2的DriverGroup的方法testClassCard2DriverGroup");
    }

    @Test(groups = "boss")
    public void testtestClassCard2BossrGroup() {
        System.out.println("这是ClassCard2的BossrGroup的方法testClassCard2BossrGroup");
    }
}

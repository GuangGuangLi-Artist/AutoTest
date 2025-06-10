package com.course.code.cases.group;

import org.testng.annotations.Test;

/**
 * TestNG中的组可以从多个类中筛选组属性相同的方法执行。
 * 比如有两个类A和B，A中有1个方法a属于组1，B中有1个方法b也属于组1，那么我们可以通过配置TestNG文件实现把这两个类中都属于1组的方法抽取出来执行。
 * https://www.cnblogs.com/beifucangqiong/p/11180233.html
 */

public class ClassCard1 {

    @Test(groups = "driver")
    public void testClassCard1DriverGroup() {
        System.out.println("这是ClassCard1的DriverGroup的方法testClassCard1DriverGroup");
    }

    @Test(groups = "boss")
    public void testtestClassCard1BossrGroup() {
        System.out.println("这是ClassCard1的BossrGroup的方法testClassCard1BossrGroup");
    }
}

package com.testNgExample.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestAnnoDependRule {

    /**
     * 依赖管理 (Dependency Management)
     * dependsOnMethods:	依赖指定的方法名。只有当被依赖方法成功后，当前方法才执行。
     * dependsOnGroups: 依赖指定的组名。该组内所有用例成功后，当前用例才执行。
     * ignoreMissingDependencies:如果依赖的方法不存在，是否忽略错误继续运行。
     *
     *
     * 执行顺序
     * testIgnoreMissingDependencies > testde_group_success > testde_success > testDependsOngroups > testDependsOnMethods
     *
     */


    private static Logger logger = LoggerFactory.getLogger(TestAnnoBaseRule.class);

    @Test()
    public void testde_success(){
        logger.info("testde_success执行");
        System.out.println("testde_success执行");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }


    @Test(dependsOnMethods = {"testde_success"})
    public void testDependsOnMethods(){
        logger.info("testDependsOnMethods执行");
        System.out.println("testDependsOnMethods执行");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");

    }

    @Test(groups = "group_success")
    public void testde_group_success(){
        logger.info("testde_group_success");
        System.out.println("testde_group_success执行");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }

    @Test(dependsOnGroups = {"group_success"})
    public void testDependsOngroups(){
        logger.info("testDependsOngroups执行");
        System.out.println("testDependsOngroups执行");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");

    }


    @Test(ignoreMissingDependencies = true,dependsOnMethods = "testignore")
    public void testIgnoreMissingDependencies(){
        logger.info("testIgnoreMissingDependencies执行");
        System.out.println("testIgnoreMissingDependencies执行");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }



}

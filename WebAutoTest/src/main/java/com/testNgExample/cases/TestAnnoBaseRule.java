package com.testNgExample.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAnnoBaseRule {
    /**
     * 用于演示TestNg注解中基础控制与执行策略
     * enabled：某个用例因环境故障暂时无法跑，但不想删除代码，设为 enabled=false。
     * priority:业务流编排：priority=1 (登录) -> priority=2 (搜索) -> priority=3 (下单)。注：过度依赖 priority 会导致维护困难，推荐用依赖关系
     * description:报告可读性：在 HTML 报告中显示“验证 VIP 用户打折逻辑”，方便非技术人员阅读。
     * groups:将该用例归类到指定的组。
     * alwaysRun :即使前置依赖失败或被跳过，该用例也强制运行。
     *
     */

    private static Logger logger = LoggerFactory.getLogger(TestAnnoBaseRule.class);



    @Test(enabled = false)
    public void testEnabledFalse(){
        logger.info("enabled = false的盈利不执行");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }

    @Test(priority = 0)
    public void testPriority0(){
        logger.info("priority = 0 控制执行顺序，值越小优先级越高");
        System.out.println("priority = 0");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");

    }
    @Test(priority = 1)
    public void testPriority1(){
        logger.info("priority = 1 控制执行顺序，值越小优先级越高");
        System.out.println("priority = 1");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");

    }

    @Test(description = "这是测试description的")
    public void testDescrption(){
        logger.info("description用于描述用例");
        System.out.println("description");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }

    // 属于 "smoke" 和 "login" 组
    @Test(groups = {"smoke","login"})
    public void testGroups_loginSuccess(){
        logger.info("将该用例归类到指定的smoke、login组");
        System.out.println("testGroups_loginSuccess");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }


    // 属于 "regression" 和 "login" 组
    @Test(groups = {"regression","login"})
    public void testGroups_loginWithInvalidPassword(){
        logger.info("将该用例归类到指定的smoke、login组");
        System.out.println("testGroups_loginWithInvalidPassword");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");

    }

    // 只属于 "regression" 组 (耗时较长，不放入冒烟)
    @Test(groups = {"regression"})
    public void testGroups_UserProfileUpdate() {
        logger.info("将该用例归类到指定的regression组");
        System.out.println("testGroups_UserProfileUpdate");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }

    @Test(groups = {"order"})
    public void testGroups_order(){
        logger.info("将该用例归类到指定的order组");
        System.out.println("testGroups_order");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }


    @Test
    public void testFail(){
        logger.info("testFail");
        Assert.assertTrue(false,"这个必须失败");
        System.out.println("testFail");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");
    }

    @Test(dependsOnMethods = {"testFail"},alwaysRun = true)
    public void test_alwaysrun(){
        logger.info("test_alwaysrun");
        System.out.println("即使testFail方法执行失败，test_alwaysrun，不跳过");
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");

    }








}

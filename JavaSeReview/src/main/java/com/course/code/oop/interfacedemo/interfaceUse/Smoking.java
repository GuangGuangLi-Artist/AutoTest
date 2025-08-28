package com.course.code.oop.interfacedemo.interfaceUse;

/**
 * 老师和学生案例,加入抽烟的额外功能
 *
 * 	Smoking:
 * 		抽烟的功能
 *
 * 	老师：
 * 		成员变量：姓名，年龄
 * 		构造方法：无参，带参
 * 		成员方法：getXxx()/setXxx(),学习，睡觉
 * 	学生：
 * 		成员变量：姓名，年龄
 * 		构造方法：无参，带参
 * 		成员方法：getXxx()/setXxx(),学习，睡觉
 *
 * 	通过老师和学生我们可以分析出人类：
 *
 * 	人：
 * 		成员变量：姓名，年龄
 * 		构造方法：无参，带参
 * 		成员方法：getXxx()/setXxx(),学习()，睡觉(){}
 *
 * 	最终的分析：
 * 	人：抽象类
 * 		成员变量：姓名，年龄
 * 		构造方法：无参，带参
 * 		成员方法：getXxx()/setXxx(),学习()，睡觉(){}
 * 			老师
 * 				部分老师抽烟
 * 			学生
 * 				部分学生抽烟
 * 	Smoking:接口
 * 		抽烟的功能
 */
public interface Smoking {
    abstract void smoking();
}

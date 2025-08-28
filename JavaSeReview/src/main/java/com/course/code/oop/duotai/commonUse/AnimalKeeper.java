package com.course.code.oop.duotai.commonUse;

/**
 * 多态最常用的场景
 *      使用父类引用调用子类对象的方法，实现运行时动态绑定。
 *      具体实现方式 ：方法参数或返回值使用父类类型，从而实现对不同子类行为的统一处理。
 */
public class AnimalKeeper {



    // 动物园管理类，使用父类类型作为参数
    public void makeAnimailSpeak(Animail animail) {
        animail.speak();// 多态：运行时调用的是子类的 speak()
    }
}

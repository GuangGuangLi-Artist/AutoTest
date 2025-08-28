package com.course.code.oop.extendDemo;

import java.util.List;

public class UseList  extends BaseClass{

    //子类自己添加的方法
    public int getListSize(List<Integer> ls){
        return ls.size();
    }
}

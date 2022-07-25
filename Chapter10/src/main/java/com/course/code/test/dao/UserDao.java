package com.course.code.test.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public Integer getUserCount();
}

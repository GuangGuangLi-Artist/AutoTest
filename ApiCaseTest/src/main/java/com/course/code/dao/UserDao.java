package com.course.code.dao;

import com.course.code.domain.LoginCase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public Integer getUserCount();

    LoginCase logingCase(Integer index);

}

package com.course.code.test.dao;

import com.course.code.test.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public Integer getUserCount();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);
}

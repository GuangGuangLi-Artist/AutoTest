package com.course.code.test.dao;

import com.course.code.test.domain.User;
import com.course.code.test.domain.UserQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    public Integer getUserCount();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

    public List<User> getAllUser();

    List<User> getUserDetail(UserQueryVo queryVo);

}

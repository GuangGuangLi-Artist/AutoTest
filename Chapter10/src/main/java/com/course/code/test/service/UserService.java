package com.course.code.test.service;

import com.course.code.test.domain.User;
import com.course.code.test.domain.UserQueryVo;

import java.util.List;

public interface UserService {
    Integer getUserCount();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

    public List<User> getAllUser();

    public List<User> getUserDetail(UserQueryVo queryVo);
}

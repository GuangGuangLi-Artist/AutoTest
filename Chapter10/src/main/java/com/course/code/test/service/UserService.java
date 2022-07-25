package com.course.code.test.service;

import com.course.code.test.domain.User;

public interface UserService {
    Integer getUserCount();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);
}

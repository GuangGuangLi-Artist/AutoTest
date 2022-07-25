package com.course.code.test.service.impl;

import com.course.code.test.dao.UserDao;
import com.course.code.test.domain.User;
import com.course.code.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer getUserCount() {
        return userDao.getUserCount();
    }

    @Override
    public void addUser(User user) {
         userDao.addUser(user);
    }
}

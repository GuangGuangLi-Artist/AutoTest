package com.course.code.service.impl;

import com.course.code.dao.UserDao;
import com.course.code.service.UserService;
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

}

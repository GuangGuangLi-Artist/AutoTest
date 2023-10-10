package com.course.code.test.service.impl;

import com.course.code.test.dao.UserDao;
import com.course.code.test.domain.User;
import com.course.code.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public List<User> getAllUser() {
         return  userDao.getAllUser();
    }
}

package com.GuangGuangLi.dao;

import com.GuangGuangLi.entity.UserInfo;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {

    UserInfo getUserInfo(int id);
}

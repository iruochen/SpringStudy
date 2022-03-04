package com.ruochen.service.impl;

import com.ruochen.dao.UserDao;
import com.ruochen.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    // 构造方式注入
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    // set 方式注入
    /*
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    */

    @Override
    public void save() {
        userDao.save();
    }
}

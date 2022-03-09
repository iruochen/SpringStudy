package com.ruochen.service.impl;

import com.ruochen.dao.UserDao;
import com.ruochen.domain.User;
import com.ruochen.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {
        return userDao.findAll();
    }
}

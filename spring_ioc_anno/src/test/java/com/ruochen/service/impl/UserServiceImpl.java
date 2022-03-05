package com.ruochen.service.impl;

import com.ruochen.dao.UserDao;
import com.ruochen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// <bean id="userService" class="com.ruochen.service.impl.UserServiceImpl">
@Component("userService")
public class UserServiceImpl implements UserService {
    // <property name="userDao" ref="userDao"></property>
    // 注解方式：userDao 注入到 userService
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}

package com.ruochen.service.impl;

import com.ruochen.dao.UserDao;
import com.ruochen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

// <bean id="userService" class="com.ruochen.service.impl.UserServiceImpl">
// @Component("userService")
@Service("userService")  // 效果与 Component 一样，可读性强
public class UserServiceImpl implements UserService {
    // <property name="userDao" ref="userDao"></property>
    // 注解方式：userDao 注入到 userService
    // @Autowired  // 按照数据类型从 Spring 容器中进行匹配
    // @Qualifier("userDao")  // 按照id值从容器中进行匹配，但是注意：@Qualifier 要结合 @Autowired 一起使用
    @Resource(name = "userDao")  // @Resource 相当于 @Autowired+@Qualifier
    private UserDao userDao;

    // 使用注解 set 方法可以删除
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

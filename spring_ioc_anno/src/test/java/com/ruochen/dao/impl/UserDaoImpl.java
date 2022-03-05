package com.ruochen.dao.impl;

import com.ruochen.dao.UserDao;
import org.springframework.stereotype.Component;

// <bean id="userDao" class="com.ruochen.dao.impl.UserDaoImpl"></bean>
// 注解方式配置
@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running....");
    }
}

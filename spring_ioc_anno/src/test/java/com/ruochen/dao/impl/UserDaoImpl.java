package com.ruochen.dao.impl;

import com.ruochen.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// <bean id="userDao" class="com.ruochen.dao.impl.UserDaoImpl"></bean>
// 注解方式配置
// @Component("userDao")
@Repository("userDao")  // 效果与 Component 一样，可读性强
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running....");
    }
}

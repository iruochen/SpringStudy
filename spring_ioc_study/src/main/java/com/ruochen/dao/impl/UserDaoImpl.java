package com.ruochen.dao.impl;

import com.ruochen.dao.UserDao;

public class UserDaoImpl implements UserDao {

    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建...");
    }

    public void init() {
        System.out.println("初始化方法...");
    }

    public void destroy() {
        System.out.println("销毁方法...");
    }
    */

    @Override
    public void save() {
        System.out.println(username + "-------" + age);
        System.out.println("save running...");
    }
}

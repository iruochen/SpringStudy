package com.ruochen.service.impl;

import com.ruochen.dao.RoleDao;
import com.ruochen.dao.UserDao;
import com.ruochen.domain.Role;
import com.ruochen.domain.User;
import com.ruochen.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        // 封装userList中的每一个user的roles数据
        for (User user : userList) {
            // 获得 user id
            Long id = user.getId();
            // 将 id 作为参数 查询当前userId 对应的role 的集合数据
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }
}
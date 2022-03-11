package com.ruochen.service.impl;

import com.ruochen.dao.RoleDao;
import com.ruochen.dao.UserDao;
import com.ruochen.domain.Role;
import com.ruochen.domain.User;
import com.ruochen.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

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

    @Override
    public void save(User user, Long[] roleIds) {
        // 1. 向 sys_user 中存储数据
        // user 中id 为空， save 后才会生成 id
        Long userId = userDao.save(user);
        // 2. 向 sys_user_role 关系表中存储多条数据
        userDao.saveUserRoleRel(userId, roleIds);
    }

    @Override
    public void del(Long userId) {
        // 1. 删除关系表 sys_user_role
        userDao.delUserRoleRel(userId);
        // 2. 删除 sys_user 表
        userDao.del(userId);
    }

    @Override
    public User login(String username, String password) {
        try {
            User user = userDao.findByUsernameAndPassword(username, password);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}

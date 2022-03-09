package com.ruochen.dao;

import com.ruochen.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}

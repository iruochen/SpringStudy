package com.ruochen.service;

import com.ruochen.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();

    void save(User user, Long[] roleIds);
}

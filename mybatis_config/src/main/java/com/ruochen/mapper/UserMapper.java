package com.ruochen.mapper;

import com.ruochen.domain.User;

import java.util.List;

public interface UserMapper {

    void save(User user);

    User findById(int id);

    List<User> fildAll();
}

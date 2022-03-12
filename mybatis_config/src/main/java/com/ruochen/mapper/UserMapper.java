package com.ruochen.mapper;

import com.ruochen.domain.User;

public interface UserMapper {

    void save(User user);

    User findById(int id);
}

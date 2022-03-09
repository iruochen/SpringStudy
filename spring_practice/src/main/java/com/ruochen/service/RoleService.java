package com.ruochen.service;

import com.ruochen.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> list();

    void save(Role role);
}

package com.ruochen.mapper;

import com.ruochen.domain.Account;

import java.util.List;

public interface AccountMapper {

    void save(Account account);

    List<Account> findAll();
}

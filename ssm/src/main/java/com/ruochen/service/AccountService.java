package com.ruochen.service;

import com.ruochen.domain.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);

    List<Account> findAll();

}

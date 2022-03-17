package com.example.service;

import com.example.pojo.Account;

import java.util.List;

public interface AccountService {

    public void save(Account account);

    public List<Account> findAll();
}

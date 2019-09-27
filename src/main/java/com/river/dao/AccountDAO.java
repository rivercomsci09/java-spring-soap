package com.river.dao;

import com.river.webservices.Account;

import java.util.List;

public interface AccountDAO {
    Account getAccount(Integer accountId);
    List<Account> getAllAccount();
    Account addAccount(Account account);
    void deleteAccount(int accountId);
}

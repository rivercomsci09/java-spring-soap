package com.river.services;

import com.river.webservices.Account;

import java.util.List;

public interface AccountService {
    Account getAccount(Integer accountId);
    List<Account> getAllAccount();
    Account addAccount(Account account);
    void deleteAccount(int accountId);

}

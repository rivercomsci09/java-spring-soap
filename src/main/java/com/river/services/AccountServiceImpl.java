package com.river.services;

import com.river.dao.AccountDAO;
import com.river.webservices.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public Account getAccount(Integer accountId) {
        return accountDAO.getAccount(accountId);
    }

    public List<Account> getAllAccount() {
        return accountDAO.getAllAccount();
    }

    public Account addAccount(Account account) {
        return accountDAO.addAccount(account);
    }

    public void deleteAccount(int accountId) {
        accountDAO.deleteAccount(accountId);
    }
}

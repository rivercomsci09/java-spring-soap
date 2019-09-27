package com.river.dao;

import com.river.util.HibernateUtil;
import com.river.webservices.Account;
import org.dozer.DozerBeanMapper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
    public void configureMapper(String mappingFileUrls) {
        dozerBeanMapper.setMappingFiles(Arrays.asList(mappingFileUrls));
    }


    public Account getAccount(Integer accountId) {
        Account account = new Account();
        configureMapper("dozer.xml");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        com.river.dao.model.Account accountEntity = new com.river.dao.model.Account();
        accountEntity = session.find(com.river.dao.model.Account.class,accountId);
        dozerBeanMapper.map(accountEntity,account);
        transaction.commit();
        session.close();
        return account;
    }

    public List<Account> getAllAccount() {

        /*configureMapper("dozer.xml");
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql="from com.river.dao.model.Account";
        Query query = session.createQuery(hql);
        List<com.river.dao.model.Account> lists = query.list();
*/
        List<Account> accounts = new ArrayList<Account>();
      /*  for (Account account:accounts) {
            for (com.river.dao.model.Account account1:lists){
                dozerBeanMapper.map(account1,account);
            }
        }
        session.close();*/
        return accounts;
    }

    public Account addAccount(Account account) {
        configureMapper("dozer.xml");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        com.river.dao.model.Account accountEntity = new com.river.dao.model.Account();
        dozerBeanMapper.map(account,accountEntity);
        session.save(accountEntity);
        transaction.commit();
        session.close();
        return account;
    }

    public void deleteAccount(int accountId) {
        configureMapper("dozer.xml");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        com.river.dao.model.Account accountEntity = new com.river.dao.model.Account();
        accountEntity.setAccountId(accountId);
        session.delete(accountEntity);
        transaction.commit();
        session.close();
    }
}

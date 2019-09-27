package com.river.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();
    private static  SessionFactory buildSessionFactory() throws HibernateException {
       try{
           return new Configuration().configure().buildSessionFactory();
       }catch(Throwable ex){
           throw new ExceptionInInitializerError(ex);
       }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }
}

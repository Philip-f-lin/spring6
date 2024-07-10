package com.example.spring6.iocxml.auto.dao;

public class UserDaoImpl implements UserDao{
    @Override
    public void addUserDao() {
        System.out.println("UserDao方法執行了");
    }
}

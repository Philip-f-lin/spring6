package com.example.spring6.iocxml.auto.service;

import com.example.spring6.iocxml.auto.dao.UserDao;
import com.example.spring6.iocxml.auto.dao.UserDaoImpl;
import org.springframework.stereotype.Service;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        userDao.addUserDao();
        System.out.println("UserService方法執行了");
//        UserDao userDao = new UserDaoImpl();
//        userDao.addUserDao();
    }

}

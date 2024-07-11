package com.philip.spring6.autowired.service;

import com.philip.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    // Dao注入
    // 第一種方式，屬性注入
    /*@Autowired // 根據類型找到對應對象，完成注入
    private UserDao userDao;*/

    //第二種方式，set注入
    /*private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    //第三種方式，構造方法注入
    /*private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }*/

    // 第四種方式，形參上注入
    /*private UserDao userDao;

    public UserServiceImpl(@Autowired UserDao userDao) {
        this.userDao = userDao;
    }*/

    // 最後一種方式：兩個註解，根據名稱注入
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        userDao.add();
    }
}

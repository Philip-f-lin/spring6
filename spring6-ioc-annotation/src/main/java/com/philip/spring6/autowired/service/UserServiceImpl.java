package com.philip.spring6.autowired.service;

import com.philip.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    // Dao注入
    // 第一種方式，屬性注入
    @Autowired // 根據類型找到對應對象，完成注入
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        userDao.add();
    }
}

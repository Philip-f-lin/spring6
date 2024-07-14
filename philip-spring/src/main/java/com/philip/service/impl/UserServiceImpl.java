package com.philip.service.impl;

import com.philip.anno.Bean;
import com.philip.anno.Di;
import com.philip.dao.UserDao;
import com.philip.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        // 調用 dao 的方法
    }
}

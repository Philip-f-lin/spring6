package com.philip.dao.impl;

import com.philip.anno.Bean;
import com.philip.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao...");
    }
}

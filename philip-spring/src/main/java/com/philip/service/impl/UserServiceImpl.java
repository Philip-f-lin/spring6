package com.philip.service.impl;

import com.philip.anno.Bean;
import com.philip.anno.Di;
import com.philip.dao.UserDao;
import com.philip.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;
}

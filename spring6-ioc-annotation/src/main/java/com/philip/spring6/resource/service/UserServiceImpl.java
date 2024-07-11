package com.philip.spring6.resource.service;

import com.philip.spring6.autowired.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("myUserService")
public class UserServiceImpl implements UserService {

    // 不指定名稱，根據屬性名稱進行注入
    @Resource
    private UserDao myUserDao;

    @Override
    public void add() {
        System.out.println("service...");
        myUserDao.add();
    }
}

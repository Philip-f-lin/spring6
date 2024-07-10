package com.example.spring6.iocxml.auto.controller;

import com.example.spring6.iocxml.auto.service.UserService;
import com.example.spring6.iocxml.auto.service.UserServiceImpl;

public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("controller方法執行了");
        userService.addUserService();
//        UserService userService = new UserServiceImpl();
//        userService.addUserService();
    }
}

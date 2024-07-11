package com.philip.spring6.autowired.controller;

import com.philip.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    // 注入service
    // 第一種方式，屬性注入
    /*@Autowired // 根據類型找到對應對象，完成注入
    private UserService userService;*/

    //第二種方式，set注入
    /*private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    //第三種方式，構造方法注入
    /*private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }*/

    // 第四種方式，形參上注入
    /*private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }*/

    // 第五種方式，只有一個有參數構造函數，無註解
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void add(){
        System.out.println("controller.... ");
        userService.add();
    }
}

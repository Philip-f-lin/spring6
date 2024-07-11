package com.philip.spring6.autowired.controller;

import com.philip.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    // 注入service
    // 第一種方式，屬性注入
    @Autowired // 根據類型找到對應對象，完成注入
    private UserService userService;

    public void add(){
        System.out.println("controller.... ");
        userService.add();
    }
}

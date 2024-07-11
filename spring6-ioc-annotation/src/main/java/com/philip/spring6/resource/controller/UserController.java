package com.philip.spring6.resource.controller;

import com.philip.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller("myUserController")
public class UserController {

    /*@Resource(name = "myUserService")
    private UserService userService;*/
    @Resource
    private UserService userService;
    public void add(){
        System.out.println("controller.... ");
        userService.add();
    }
}

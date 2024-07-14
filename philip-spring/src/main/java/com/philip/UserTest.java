package com.philip;

import com.philip.bean.AnnotationApplicationContext;
import com.philip.service.UserService;

public class UserTest {
    public static void main(String[] args) throws Exception {
        AnnotationApplicationContext context = new AnnotationApplicationContext("com.philip");
        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}

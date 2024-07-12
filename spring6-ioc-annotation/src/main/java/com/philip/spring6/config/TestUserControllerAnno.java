package com.philip.spring6.config;

import com.philip.spring6.resource.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserControllerAnno {
    public static void main(String[] args) {
        // 加載配置類
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller = context.getBean(UserController.class);
        controller.add();

    }
}

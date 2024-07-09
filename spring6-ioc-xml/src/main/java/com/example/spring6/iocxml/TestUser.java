package com.example.spring6.iocxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {

        // 1. 根据id获取bean
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User)context.getBean("user");
        User user1 = (User)context.getBean("user1");
        System.out.println("1 根据id获取bean: " + user);
        System.out.println("1 根据id获取bean: " + user1);

        // 2. 根据类型获取bean
//        User user2 = (User)context.getBean(User.class);
//        System.out.println("2 根据类型获取bean: " + user2);

        // 3. 根据id和类型bean
//        User user3 = (User)context.getBean("user", User.class);
//        System.out.println("3 根据id和类型bean: " + user3);



    }
}

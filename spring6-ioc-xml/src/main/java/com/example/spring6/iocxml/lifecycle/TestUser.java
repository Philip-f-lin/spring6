package com.example.spring6.iocxml.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser  {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
        User user = context.getBean("user", User.class);
        System.out.println("6 bean對象創建完成，可以使用");
        System.out.println(user);
        context.close(); //銷毀
    }
}

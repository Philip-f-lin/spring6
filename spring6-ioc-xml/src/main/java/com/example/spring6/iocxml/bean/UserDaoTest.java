package com.example.spring6.iocxml.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 此步驟等同於 UserDao userDao = new UserDaoImpl();
        // 根據類型獲取接口對應 bean
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        userDao.run();
    }
}

package com.example.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class TestUser {

    // 創建 logger 物件
    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject(){
         // 加載spring配置文件，創建物件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

         // 獲取創建的物件
        User user = (User)context.getBean("user");
        System.out.println(user);

         // 使用物件調用方法進行測試
        user.add();

        // 手動寫日誌
        logger.info("執行成功");

    }

    @Test
    public void testUserObject1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 獲取 User 類的 Class 對象，clazz 是一個表示 User 類的 Class 對象
        Class clazz = Class.forName("com.example.spring6.User");

        // 通過反射機制調用無參構造函數創建 User 對象
        User user = (User)clazz.getDeclaredConstructor().newInstance();

    }




}

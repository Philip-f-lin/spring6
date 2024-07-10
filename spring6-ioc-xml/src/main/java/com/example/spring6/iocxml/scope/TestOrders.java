package com.example.spring6.iocxml.scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrders {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders orders1 = context.getBean("orders", Orders.class);
        System.out.println(orders1);
        Orders orders2 = context.getBean("orders", Orders.class);
        System.out.println(orders2);
    }
}

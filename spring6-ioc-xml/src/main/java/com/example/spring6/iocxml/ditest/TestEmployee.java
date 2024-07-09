package com.example.spring6.iocxml.ditest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-diarray.xml");
        Employee employee = (Employee)context.getBean("employee", Employee.class);
        employee.work();
    }
}

package com.example.spring6.iocxml.ditest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDepartment {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-dilist.xml");
        Department department = (Department) context.getBean("department", Department.class);
        department.info();
    }
}

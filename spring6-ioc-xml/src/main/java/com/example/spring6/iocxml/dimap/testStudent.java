package com.example.spring6.iocxml.dimap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testStudent {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-dimap.xml");
        Student student = context.getBean("student", Student.class);
        student.run();
    }
}

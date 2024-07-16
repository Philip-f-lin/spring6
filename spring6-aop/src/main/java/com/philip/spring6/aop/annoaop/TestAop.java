package com.philip.spring6.aop.annoaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public void testAdd(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Calculator bean = context.getBean(Calculator.class);
        bean.add(1,3);
    }
}

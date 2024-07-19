package com.philip.spring6.aop.xmlaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public void testAdd(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanaop.xml");
        Calculator bean = context.getBean(Calculator.class);
        bean.add(10,31);
    }
}

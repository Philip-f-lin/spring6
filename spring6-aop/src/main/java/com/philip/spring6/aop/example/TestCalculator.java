package com.philip.spring6.aop.example;

public class TestCalculator {
    public static void main(String[] args) {
         //1 創建代理對象
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getTarget();
        proxy.add(1, 2);
    }
}

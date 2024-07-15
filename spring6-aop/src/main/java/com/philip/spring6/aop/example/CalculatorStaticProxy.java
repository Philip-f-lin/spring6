package com.philip.spring6.aop.example;

public class CalculatorStaticProxy implements Calculator{

    // 被代理目標對象傳遞進來
    private Calculator calculator;

    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        // 輸出日誌
        System.out.println("[日誌] add 方法開始了，参數是：" + i + "," + j);

        // 調用目標對象的方法實現核心業務
        int addResult = calculator.add(i, j);

        System.out.println("[日誌] add 方法結束了，结果是：" + addResult);
        return addResult;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}

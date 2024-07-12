package com.philip.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class TestCar {

    //1. 獲取Class對象多種方式
    @Test
    public void test01() throws Exception {
        //1. 類名.class
        Class<Car> clazz1 = Car.class;
        //2. 對象.getclass()
        Class<? extends Car> clazz2 = new Car().getClass();
        //3. class.forName("全路徑")
        Class<?> clazz3 = Class.forName("com.philip.reflect.Car");

        //實例化
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
    }

        //2. 獲取構造方法
        //3. 獲取屬性
        //4. 獲取方法

}

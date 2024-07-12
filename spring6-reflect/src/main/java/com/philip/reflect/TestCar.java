package com.philip.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
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
    @Test
    public void Test02() throws Exception{
        Class<Car> clazz = Car.class;
        // getConstructors() 獲取所有public的構造方法
        //Constructor<?>[] constructors = clazz.getConstructors();

        // getDeclaredConstructors() 獲取所有的構造方法public private
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println("方法名稱: " + c.getName() + " 參數個數: " + c.getParameterCount());
        }

        // 指定有參數構造創建對象
        //1 構造public
        /*Constructor<Car> c1 = clazz.getConstructor(String.class, int.class, String.class);
        Car car1 = c1.newInstance("Tesla", 10, "黑色");
        System.out.println(car1);*/

        //2 構造private
        Constructor<Car> c2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true);
        Car car2 = c2.newInstance("Toyota", 15, "白色");
        System.out.println(car2);
    }
        //3. 獲取屬性
        //4. 獲取方法

}

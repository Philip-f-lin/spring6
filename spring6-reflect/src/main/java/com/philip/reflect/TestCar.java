package com.philip.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    @Test
    public void test03() throws Exception{
        Class<Car> clazz = Car.class;
        Car car = clazz.getConstructor().newInstance();
        // 獲取所有public屬性
        Field[] fields = clazz.getFields();
        // 獲取所有屬性(包含私有屬性)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (declaredField.getName().equals("name")){
                declaredField.set(car, "Benz");
            }
            System.out.println(declaredField.getName());
            System.out.println(car);
        }

    }
        //4. 獲取方法

    @Test
    public void test04() throws Exception{
        Car car = new Car("保時捷", 20, "藍色");
        Class<? extends Car> clazz = car.getClass();
        // 1 public方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            // 執行方法 toString
            if (method.getName().equals("toString")){
                String invoke = (String) method.invoke(car);
                System.out.println("toString方法執行：" + invoke);
            }
        }

        //2 private 方法
        Method[] methodsAll = clazz.getDeclaredMethods();
        for (Method method : methodsAll) {
            // 執行方法 run
            if (method.getName().equals("run")){
                method.setAccessible(true);
                method.invoke(car);
            }
        }
    }

}

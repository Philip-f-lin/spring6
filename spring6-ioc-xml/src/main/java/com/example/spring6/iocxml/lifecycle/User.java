package com.example.spring6.iocxml.lifecycle;

public class User {
    private String name;

    // 無參數構造
    public User(){
        System.out.println("1 bean对象创建，調用無參數構造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2 给bean对象设置属性");
        this.name = name;
    }

    // 初始化方法
    public void initMethod(){
        System.out.println("4 bean对象初始化，調用指定的初始化方法");
    }

    // 銷毀的方法
    public void destroyMethod(){
        System.out.println("7 bean对象销毁，調用指定的銷毀方法");
    }




}

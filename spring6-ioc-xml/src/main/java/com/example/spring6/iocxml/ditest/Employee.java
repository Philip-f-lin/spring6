package com.example.spring6.iocxml.ditest;

import java.util.Arrays;

// 員工類
public class Employee {

    // 對象類型屬性：員工屬於某個部門
    private Department department;
    // 員工名稱
    private String employeeName;
    // 員工年齡
    private String age;

    // 喜好
    private String[] loves;

    public void work(){
        System.out.println(employeeName + "Employee work..." + age);
        department.info();
        System.out.println(Arrays.toString(loves));
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }
}

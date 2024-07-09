package com.example.spring6.iocxml.ditest;

import java.util.List;

public class Department {

    // 一個部門有很多員工
    private List<Employee> employeeList;
    private String departmentName;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void info(){
        System.out.println("部門名稱" + departmentName);
    }
}

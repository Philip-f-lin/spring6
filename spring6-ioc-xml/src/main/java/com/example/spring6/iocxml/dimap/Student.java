package com.example.spring6.iocxml.dimap;

import java.util.Map;

public class Student {

    private Map<String, Teacher> teacherMap;
    private String studentId;
    private String studentName;

    public void run(){
        System.out.println("學生ID: " + studentId + " " + "學生姓名：" + studentName);
        System.out.println(teacherMap);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }
}

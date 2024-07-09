package com.example.spring6.iocxml.dimap;

public class Lesson {
    private String LessonName;

    public String getLessonName() {
        return LessonName;
    }

    public void setLessonName(String lessonName) {
        LessonName = lessonName;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "LessonName='" + LessonName + '\'' +
                '}';
    }
}

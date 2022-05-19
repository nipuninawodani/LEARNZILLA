package com.uok.learnzilla.HomeComponents.myCourses.model;


public class Courses {
    private String courseId;
    private String courseName;
    private String teacherName;

    public Courses(String courseId, String courseName, String teacherName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }
}


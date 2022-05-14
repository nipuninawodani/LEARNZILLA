package com.uok.learnzilla.HomeComponents.results;

public class Results {
    private String course_name;
    private String course_year;
    private String grade;

    public Results(String course_name, String course_year, String grade) {
        this.course_name = course_name;
        this.course_year = course_year;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public String getCourse_year() {
        return course_year;
    }

    public String getCourse_name() {
        return course_name;
    }
}

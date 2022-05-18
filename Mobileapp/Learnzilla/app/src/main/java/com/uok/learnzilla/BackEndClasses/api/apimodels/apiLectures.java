package com.uok.learnzilla.BackEndClasses.api.apimodels;

public class apiLectures {
    private Long lectureid;
    private String academic_year;
    private String course_code;
    private String description;
    private String week;

    public apiLectures(Long lectureid, String academic_year, String course_code, String description, String week) {
        this.lectureid = lectureid;
        this.academic_year = academic_year;
        this.course_code = course_code;
        this.description = description;
        this.week = week;
    }

    public apiLectures(String academic_year, String course_code, String description, String week) {
        this.academic_year = academic_year;
        this.course_code = course_code;
        this.description = description;
        this.week = week;
    }

    public Long getLectureid() {
        return lectureid;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getDescription() {
        return description;
    }

    public String getWeek() {
        return week;
    }
}

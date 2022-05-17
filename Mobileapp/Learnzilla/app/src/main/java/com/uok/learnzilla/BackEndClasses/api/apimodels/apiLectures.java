package com.uok.learnzilla.BackEndClasses.api.apimodels;

public class apiLectures {
    private Long lecture_id;
    private String academic_year;
    private String course_code;
    private String description;
    private String week;

    public apiLectures(Long lecture_id, String academic_year, String course_code, String description, String week) {
        this.lecture_id = lecture_id;
        this.academic_year = academic_year;
        this.course_code = course_code;
        this.description = description;
        this.week = week;
    }

    public Long getLecture_id() {
        return lecture_id;
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

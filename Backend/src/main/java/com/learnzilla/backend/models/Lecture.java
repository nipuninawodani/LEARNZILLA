package com.learnzilla.backend.models;

import javax.persistence.*;

@Entity
public class Lecture  {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "lecture_id")

    private String lecture_id;
    private String academic_year;
    private String course_code;
    private String description;
    private String week;


    public Lecture(){

    }

    public Lecture(String lecture_id,String academic_year,String course_code,String description,String week){
        this.academic_year=academic_year;
        this.course_code=course_code;
        this.description=description;
        this.week=week;
        this.lecture_id=lecture_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(String lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}

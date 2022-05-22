package com.learnzilla.backend.models;

import javax.persistence.*;

@Entity
public class Lecture  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long lectureid;
    private String academic_year;
    private String course_code;
    private String description;
    private String title;


    public Lecture(){

    }

    public Lecture(Long lectureid, String academic_year, String course_code, String description, String title){
        this.academic_year=academic_year;
        this.course_code=course_code;
        this.description=description;
        this.title = title;
        this.lectureid = lectureid;
    }

    public Lecture(String academic_year,String course_code,String description,String title){
        this.academic_year=academic_year;
        this.course_code=course_code;
        this.description=description;
        this.title = title;
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

    public Long getLectureid() {
        return lectureid;
    }

    public void setLectureid(Long lecture_id) {
        this.lectureid = lecture_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package com.learnzilla.backend.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "course_code", "academic_year" }) })
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "courseid")

    private Long courseid;
    @Column(name = "academic_year")
    private String academic_year;
    @Column(name = "course_code")
    private String course_code;
    private String level;
    private String semester;
    private String teacher_id;
    private String title;
    private String description;
    private String language;


    public Course() {

    }

    public Course(Long courseid, String course_code, String academic_year, String level, String semester, String teacher_id, String title, String description, String language) {
        this.courseid = courseid;
        this.academic_year=academic_year;
        this.course_code=course_code;
        this.description=description;
        this.level=level;
        this.semester=semester;
        this.teacher_id=teacher_id;
        this.title=title;
        this.language=language;
    }

    public Course(String course_code, String academic_year, String level, String semester, String teacher_id, String title, String description, String language) {
        this.academic_year=academic_year;
        this.course_code=course_code;
        this.description=description;
        this.level=level;
        this.semester=semester;
        this.teacher_id=teacher_id;
        this.title=title;
        this.language=language;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long course_id) {
        this.courseid = course_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}



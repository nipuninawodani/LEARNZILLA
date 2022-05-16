package com.learnzilla.backend.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(Course.class)
public class Course implements Serializable {

    @Id
    private String course_code;

    @Id
    private String academic_year;

    private String level;
    private String semester;
    private String teacher_id;
    private String description;

    public Course() {

    }

    public Course(String course_code, String academic_year, String level, String semester, String teacher_id, String description) {
        super();
        this.academic_year=academic_year;
        this.course_code=course_code;
        this.description=description;
        this.level=level;
        this.semester=semester;
        this.teacher_id=teacher_id;
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
}



package com.learnzilla.backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(Enrollment.class)
public class Enrollment implements Serializable {

    @Id
    private String academic_year;

    @Id
    private String course_code;

    @Id
    private String student_id;

    private String overall_grade;


    public String getAcademic_year() {
        return academic_year;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getOverall_grade() {
        return overall_grade;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setOverall_grade(String overall_grade) {
        this.overall_grade = overall_grade;
    }
}

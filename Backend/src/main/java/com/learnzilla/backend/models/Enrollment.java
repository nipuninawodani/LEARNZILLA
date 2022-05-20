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
    private int student_id;

    private String overall_grade;

    public Enrollment(){

    }
    public Enrollment(String academic_year,String course_code,int student_id,String overall_grade){
        this.academic_year=academic_year;
        this.course_code=course_code;
        this.student_id=student_id;
        this.overall_grade=overall_grade;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getOverall_grade() {
        return overall_grade;
    }

    public void setOverall_grade(String overall_grade) {
        this.overall_grade = overall_grade;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}

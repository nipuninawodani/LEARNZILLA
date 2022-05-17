package com.learnzilla.backend.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Enrollment implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "enrollmentid")
    private Long enrollmentid;

    private String academic_year;

    private String course_code;

    private String student_id;

    private String overall_grade;

    public Enrollment(){

    }
    public Enrollment(Long enrollmentid, String academic_year,String course_code,String student_id,String overall_grade){
        this.enrollmentid=enrollmentid;
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

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public Long getEnrollmentid() {
        return enrollmentid;
    }

    public void setEnrollmentid(Long enrollmentid) {
        this.enrollmentid = enrollmentid;
    }
}

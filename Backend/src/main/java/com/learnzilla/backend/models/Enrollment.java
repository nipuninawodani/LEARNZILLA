package com.learnzilla.backend.models;

import javax.persistence.Entity;

@Entity
public class Enrollment {
    private String academic_year;
    private String course_code;
    private String student_id;
    private String overall_grade;
}

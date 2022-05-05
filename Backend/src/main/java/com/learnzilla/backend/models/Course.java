package com.learnzilla.backend.models;

import javax.persistence.Entity;

@Entity
public class Course {
    private String course_code;
    private String academic_year;
    private String level;
    private String semester;
    private String teacher_id;
}

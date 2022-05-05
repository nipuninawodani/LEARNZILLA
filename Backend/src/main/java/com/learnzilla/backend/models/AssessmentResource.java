package com.learnzilla.backend.models;

import javax.persistence.Entity;

@Entity
public class AssessmentResource {
    private String assessment_id;
    private String academic_year;
    private String course_code;
    private String resource;
}

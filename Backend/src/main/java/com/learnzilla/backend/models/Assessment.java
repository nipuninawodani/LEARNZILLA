package com.learnzilla.backend.models;

import javax.persistence.*;

@Entity
public class Assessment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "assessment_id")

    private String assessment_id;
    private String academic_year;
    private String course_code;
    private String description;
    private String week;
}

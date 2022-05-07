package com.learnzilla.backend.models;

import javax.persistence.*;

@Entity
public class Lecture  {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "lecture_id")

    private String lecture_id;
    private String academic_year;
    private String course_code;
    private String description;
    private String week;

}

package com.learnzilla.backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(LectureResource.class)
public class LectureResource implements Serializable {

    @Id
    private String lecture_id;

    @Id
    private String academic_year;

    @Id
    private String course_code;

    @Id
    private String resource;

}

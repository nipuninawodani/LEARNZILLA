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
}

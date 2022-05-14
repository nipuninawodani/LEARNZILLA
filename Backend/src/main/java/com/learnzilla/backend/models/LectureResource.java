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
    private String resource;


    public LectureResource(){

    }

    public LectureResource(String lecture_id, String resource){
        this.lecture_id=lecture_id;
        this.resource=resource;
    }

    public String getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(String lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}

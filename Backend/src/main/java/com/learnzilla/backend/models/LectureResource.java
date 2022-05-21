package com.learnzilla.backend.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LectureResource implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "lectureresourseid")
    private Long lectureresourseid;

    private Long lecture_id;

    private String resource;

    private String filename;
    public LectureResource(){

    }

    public LectureResource(Long lectureresourseid, Long lecture_id, String resource,String filename){
        this.lectureresourseid = lectureresourseid;
        this.lecture_id=lecture_id;
        this.resource=resource;
        this.filename=filename;
    }

    public LectureResource(Long lecture_id, String resource,String filename){
        this.lecture_id=lecture_id;
        this.resource=resource;
        this.filename=filename;
    }

    public Long getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(Long lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Long getLectureresourseid() {
        return lectureresourseid;
    }

    public void setLectureresourseid(Long lectureresourseid) {
        this.lectureresourseid = lectureresourseid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}

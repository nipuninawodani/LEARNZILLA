package com.uok.learnzilla.BackEndClasses.api.apimodels;

public class apiLectureResources {

    private Long lectureresourseid;
    private Long lecture_id;
    private String resource;

    public apiLectureResources(Long lectureresourseid, Long lecture_id, String resource) {
        this.lectureresourseid = lectureresourseid;
        this.lecture_id = lecture_id;
        this.resource = resource;
    }

    public apiLectureResources(Long lecture_id, String resource) {
        this.lecture_id = lecture_id;
        this.resource = resource;
    }

    public Long getLectureresourseid() {
        return lectureresourseid;
    }

    public Long getLecture_id() {
        return lecture_id;
    }

    public String getResource() {
        return resource;
    }
}

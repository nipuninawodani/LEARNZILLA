package com.uok.learnzilla.BackEndClasses.api.apimodels;

public class apiLectureResources {

    private String lecture_id;
    private String resource;

    public String getLecture_id() {
        return lecture_id;
    }

    public String getResource() {
        return resource;
    }

    public apiLectureResources(String lecture_id, String resource) {
        this.lecture_id = lecture_id;
        this.resource = resource;
    }
}

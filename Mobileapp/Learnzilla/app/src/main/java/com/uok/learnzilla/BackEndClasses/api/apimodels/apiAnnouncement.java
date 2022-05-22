package com.uok.learnzilla.BackEndClasses.api.apimodels;

import java.util.Date;

public class apiAnnouncement {
    private Integer id;
    private String course_code;
    private String title;
    private String message;
    private Date date;

    public apiAnnouncement(Integer id, String course_code, String title, String message, Date date) {
        this.id = id;
        this.course_code = course_code;
        this.title = title;
        this.message = message;
        this.date = date;
    }

    public apiAnnouncement(String course_code, String title, String message, Date date) {
        this.course_code = course_code;
        this.title = title;
        this.message = message;
        this.date = date;
    }
}

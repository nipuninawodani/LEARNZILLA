package com.uok.learnzilla.BackEndClasses.api.apimodels;

public class apiCourses {


    private String course_code;
    private String academic_year;
    private String level;
    private String semester;
    private String teacher_id;
    private String description;

    public apiCourses(String course_code, String academic_year, String level, String semester, String teacher_id, String description) {
        this.course_code = course_code;
        this.academic_year = academic_year;
        this.level = level;
        this.semester = semester;
        this.teacher_id = teacher_id;
        this.description = description;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public String getLevel() {
        return level;
    }


    public String getTeacher_id() {
        return teacher_id;
    }


    public String getDescription() {
        return description;
    }
}

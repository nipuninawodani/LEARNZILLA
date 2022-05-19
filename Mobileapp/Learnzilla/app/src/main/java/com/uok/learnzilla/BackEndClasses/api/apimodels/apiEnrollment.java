package com.uok.learnzilla.BackEndClasses.api.apimodels;

public class apiEnrollment {
    private String academic_year;
    private String course_code;
    private String student_id;
    private String overall_grade;

    public String getAcademic_year() {
        return academic_year;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getOverall_grade() {
        return overall_grade;
    }

    public apiEnrollment(String academic_year, String course_code, String student_id, String overall_grade) {
        this.academic_year = academic_year;
        this.course_code = course_code;
        this.student_id = student_id;
        this.overall_grade = overall_grade;
    }
}

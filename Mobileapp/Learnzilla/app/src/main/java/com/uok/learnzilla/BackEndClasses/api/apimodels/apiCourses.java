package com.uok.learnzilla.BackEndClasses.api.apimodels;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import kotlinx.parcelize.Parcelize;

@SuppressLint("ParcelCreator")
@Parcelize
public class apiCourses implements Parcelable {


    private Long courseid;
    private String academic_year;
    private String course_code;
    private String level;
    private String semester;
    private String teacher_id;
    private String title;
    private String description;
    private String language;

    public apiCourses(Long courseid, String academic_year, String course_code, String level, String semester, String teacher_id, String title, String description, String language) {
        this.courseid = courseid;
        this.academic_year = academic_year;
        this.course_code = course_code;
        this.level = level;
        this.semester = semester;
        this.teacher_id = teacher_id;
        this.title = title;
        this.description = description;
        this.language = language;
    }

    public apiCourses(String academic_year, String course_code, String level, String semester, String teacher_id, String title, String description, String language) {
        this.academic_year = academic_year;
        this.course_code = course_code;
        this.level = level;
        this.semester = semester;
        this.teacher_id = teacher_id;
        this.title = title;
        this.description = description;
        this.language = language;
    }

    public Long getCourseid() {
        return courseid;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getLevel() {
        return level;
    }

    public String getSemester() {
        return semester;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}

package com.uok.learnzilla.BackEndClasses.api.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import kotlinx.parcelize.Parcelize;

@Parcelize
public class apiLectures implements Parcelable {
    private Long lectureid;
    private String academic_year;
    private String course_code;
    private String description;
    private String week;

    public apiLectures(Long lectureid, String academic_year, String course_code, String description, String week) {
        this.lectureid = lectureid;
        this.academic_year = academic_year;
        this.course_code = course_code;
        this.description = description;
        this.week = week;
    }

    public apiLectures(String academic_year, String course_code, String description, String week) {
        this.academic_year = academic_year;
        this.course_code = course_code;
        this.description = description;
        this.week = week;
    }

    protected apiLectures(Parcel in) {
        if (in.readByte() == 0) {
            lectureid = null;
        } else {
            lectureid = in.readLong();
        }
        academic_year = in.readString();
        course_code = in.readString();
        description = in.readString();
        week = in.readString();
    }

    public static final Creator<apiLectures> CREATOR = new Creator<apiLectures>() {
        @Override
        public apiLectures createFromParcel(Parcel in) {
            return new apiLectures(in);
        }

        @Override
        public apiLectures[] newArray(int size) {
            return new apiLectures[size];
        }
    };

    public Long getLectureid() {
        return lectureid;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public String getCourse_code() {
        return course_code;
    }

    public String getDescription() {
        return description;
    }

    public String getWeek() {
        return week;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}

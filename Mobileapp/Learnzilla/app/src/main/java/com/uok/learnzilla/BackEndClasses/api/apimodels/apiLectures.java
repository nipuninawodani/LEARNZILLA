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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public apiLectures(Long lectureid, String academic_year, String course_code, String description, String title) {
        this.lectureid = lectureid;
        this.academic_year = academic_year;
        this.course_code = course_code;
        this.description = description;
        this.title = title;
    }

    public apiLectures(String academic_year, String course_code, String description, String title) {
        this.academic_year = academic_year;
        this.course_code = course_code;
        this.description = description;
        this.title = title;
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
        title = in.readString();
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (lectureid == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(lectureid);
        }
        parcel.writeString(academic_year);
        parcel.writeString(course_code);
        parcel.writeString(description);
        parcel.writeString(title);
    }
}

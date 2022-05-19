package com.uok.learnzilla.enrollment;

import android.os.Parcel;
import android.os.Parcelable;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;

import kotlinx.android.parcel.Parcelize;


@Parcelize
public class EnrollViewModel implements Parcelable {
     apiCourses courses;
     String TeacherName;

    public apiCourses getCourses() {
        return courses;
    }
    public String getTeacherName() {
        return TeacherName;
    }

    public EnrollViewModel(apiCourses courses, String teacherName) {
        this.courses = courses;
        TeacherName = teacherName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}

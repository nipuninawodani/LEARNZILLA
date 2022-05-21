package com.uok.learnzilla.BackEndClasses.api.apimodels;

import android.os.Parcel;
import android.os.Parcelable;

import kotlinx.parcelize.Parcelize;

@Parcelize
public class apiEnrollment implements Parcelable {
    private Long enrollmentid;
    private String academic_year;
    private String course_code;
    private String student_id;
    private String overall_grade;

    public apiEnrollment(String academic_year, String course_code, String student_id, String overall_grade) {
        this.academic_year = academic_year;
        this.course_code = course_code;
        this.student_id = student_id;
        this.overall_grade = overall_grade;
    }

    public apiEnrollment(Long enrollmentid, String academic_year, String course_code, String student_id, String overall_grade) {
        this.enrollmentid = enrollmentid;
        this.academic_year = academic_year;
        this.course_code = course_code;
        this.student_id = student_id;
        this.overall_grade = overall_grade;
    }


    protected apiEnrollment(Parcel in) {
        if (in.readByte() == 0) {
            enrollmentid = null;
        } else {
            enrollmentid = in.readLong();
        }
        academic_year = in.readString();
        course_code = in.readString();
        student_id = in.readString();
        overall_grade = in.readString();
    }

    public static final Creator<apiEnrollment> CREATOR = new Creator<apiEnrollment>() {
        @Override
        public apiEnrollment createFromParcel(Parcel in) {
            return new apiEnrollment(in);
        }

        @Override
        public apiEnrollment[] newArray(int size) {
            return new apiEnrollment[size];
        }
    };

    public Long getEnrollmentid() {
        return enrollmentid;
    }

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

    public void setOverall_grade(String grade){
        this.overall_grade = grade;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

}

package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiEnrollment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EnrollmentApiServices {
    @GET("/enrollment/course_code={course_code}&academic_year={academic_year}")
    Call<List<apiEnrollment>> getEnrollmentsByCourse (@Path("course_code") String course_code,@Path("academic_year") String academic_year);

    @GET("/enrollment/student_id={student_id}")
    Call<List<apiEnrollment>> getEnrollmentsByStudent(@Path("student_id") String student_id);

    @GET("/enrollment/check/course_code={course_code}&academic_year={academic_year}&student_id={student_id}")
    Call<apiEnrollment> checkEnroll(@Path("course_code") String course_code,@Path("academic_year") String academic_year,@Path("student_id") String student_id);

    @POST("/enrollment")
    Call<Void> addEnrollment(@Body apiEnrollment enrollment);
}

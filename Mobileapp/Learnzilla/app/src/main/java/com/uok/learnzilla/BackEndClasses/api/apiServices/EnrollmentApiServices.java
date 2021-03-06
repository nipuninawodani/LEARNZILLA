package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiEnrollment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EnrollmentApiServices {
    @GET("/learnzilla/enrollment/gets/course_code={course_code}&academic_year={academic_year}")
    Call<List<apiEnrollment>> getEnrollmentsByCourse (@Path("course_code") String course_code,@Path("academic_year") String academic_year,@Header("Authorization") String Token);

    @GET("/learnzilla/enrollment/get/student_id={student_id}")
    Call<List<apiEnrollment>> getEnrollmentsByStudent(@Path("student_id") String student_id,@Header("Authorization") String Token);

    @GET("/learnzilla/enrollment/check/course_code={course_code}&academic_year={academic_year}&student_id={student_id}")
    Call<apiEnrollment> checkEnroll(@Path("course_code") String course_code,@Path("academic_year") String academic_year,@Path("student_id") String student_id,@Header("Authorization") String Token);

    @GET("/learnzilla/enrollment/get/{enrollmentid}")
    Call<apiEnrollment> getEnrollmentByEnrollmentID(@Path("enrollmentid") Long ID,@Header("Authorization") String Token);

    @POST("/learnzilla/enrollment")
    Call<Void> addEnrollment(@Body apiEnrollment enrollment,@Header("Authorization") String Token);

    @POST("/learnzilla/enrollment/edit")
    Call<Void> updateEnrollment(@Body apiEnrollment enrollment,@Header("Authorization") String Token);

    @POST("/learnzilla/enrollment/delete")
    Call<Void> deleteEnrollment(@Body apiEnrollment enrollment,@Header("Authorization") String Token);

}

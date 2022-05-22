package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiEnrollment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EnrollmentApiServices {
    @GET("/learnzilla/enrollment/gets/course_code={course_code}&academic_year={academic_year}?access_token={access_token}")
    Call<List<apiEnrollment>> getEnrollmentsByCourse (@Path("course_code") String course_code,@Path("academic_year") String academic_year,@Path("access_token") String Token);

    @GET("/learnzilla/enrollment/get/student_id={student_id}?access_token={access_token}")
    Call<List<apiEnrollment>> getEnrollmentsByStudent(@Path("student_id") String student_id,@Path("access_token") String Token);

    @GET("/learnzilla/enrollment/check/course_code={course_code}&academic_year={academic_year}&student_id={student_id}?access_token={access_token}")
    Call<apiEnrollment> checkEnroll(@Path("course_code") String course_code,@Path("academic_year") String academic_year,@Path("student_id") String student_id,@Path("access_token") String Token);

    @GET("/learnzilla/enrollment/get/{enrollmentid}?access_token={access_token}")
    Call<apiEnrollment> getEnrollmentByEnrollmentID(@Path("enrollmentid") Long ID,@Path("access_token") String Token);

    @POST("/learnzilla/enrollment?access_token={access_token}")
    Call<Void> addEnrollment(@Body apiEnrollment enrollment,@Path("access_token") String Token);

    @POST("/learnzilla/enrollment/edit?access_token={access_token}")
    Call<Void> updateEnrollment(@Body apiEnrollment enrollment,@Path("access_token") String Token);

    @POST("/learnzilla/enrollment/delete?access_token={access_token}")
    Call<Void> deleteEnrollment(@Body apiEnrollment enrollment,@Path("access_token") String Token);

}

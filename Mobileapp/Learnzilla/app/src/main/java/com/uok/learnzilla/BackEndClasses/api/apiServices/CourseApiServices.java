package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CourseApiServices {

    @GET("/learnzilla/course/get/{course_code}&{academic_year}?access_token={access_token}")
    Call<apiCourses> getCourseByCourseCode(@Path("course_code") String course_code,@Path("academic_year") String academic_year,@Path("access_token")String Token );

    @GET("/learnzilla/course/{teacher_id}")
    Call<List<apiCourses>> getCourseByTeacherId(@Path("teacher_id") String teacher_id,@Header("Authorization") String Token);

    @GET("/learnzilla/course")
    Call<List<apiCourses>> getAllCourses(@Header("Authorization") String Token);

    @POST("/learnzilla/course")
    Call<Void> addCourse(@Body apiCourses courses,@Header("Authorization") String Token);

    @POST("/learnzilla/course/edit")
    Call<Void> UpdateCourse(@Body apiCourses course,@Header("Authorization") String Token);

    @POST("/learnzilla/course/delete")
    Call<Void> DeleteCourse(@Body apiCourses course,@Header("Authorization") String Token);


}

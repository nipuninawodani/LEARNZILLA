package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CourseApiServices {

    @GET("/learnzilla//course/get/{course_code}&{academic_year}?access_token={access_token}")
    Call<apiCourses> getCourseByCourseCode(@Path("course_code") String course_code,@Path("academic_year") String academic_year,@Path("access_token") String Token);

    @GET("/learnzilla//course/{teacher_id}?access_token={access_token}")
    Call<List<apiCourses>> getCourseByTeacherId(@Path("teacher_id") String teacher_id,@Path("access_token") String Token);

    @GET("/learnzilla//course?access_token={access_token}")
    Call<List<apiCourses>> getAllCourses(@Path("access_token") String Token);

    @POST("/course?access_token={access_token}")
    Call<Void> addCourse(@Body apiCourses courses,@Path("access_token") String Token);

    @POST("/course/edit?access_token={access_token}")
    Call<Void> UpdateCourse(@Body apiCourses course,@Path("access_token") String Token);

    @POST("/course/delete?access_token={access_token}")
    Call<Void> DeleteCourse(@Body apiCourses course,@Path("access_token") String Token);


}

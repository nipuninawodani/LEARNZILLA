package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CourseApiServices {

    @GET("/learnzilla//course/get/{course_code}&{academic_year}")
    Call<apiCourses> getCourseByCourseCode(@Path("course_code") String course_code,@Path("academic_year") String academic_year);

    @GET("/learnzilla//course/{teacher_id}")
    Call<List<apiCourses>> getCourseByTeacherId(@Path("teacher_id") String teacher_id);

    @GET("/learnzilla//course")
    Call<List<apiCourses>> getAllCourses();

    @POST("/course")
    Call<Void> addCourse(@Body apiCourses courses);

    @POST("/course/edit")
    Call<Void> UpdateCourse(@Body apiCourses course);

    @POST("/course/delete")
    Call<Void> DeleteCourse(@Body apiCourses course);


}

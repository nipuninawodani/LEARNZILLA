package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CourseApiServices {

    @GET("/course/{course_code}&{academic_year}")
    Call<apiCourses> getCourseByCourseCode(@Path("course_code") String course_code,@Path("academic_year") String academic_year);

    @GET("/course")
    Call<List<apiCourses>> getAllCourses();

    @POST("/course")
    Call<apiCourses> addCourse(@Body apiCourses courses);

}

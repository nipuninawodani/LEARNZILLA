package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CourseApiServices {

    @GET("/course")
    Call<List<apiCourses>> getAllCourses();

}

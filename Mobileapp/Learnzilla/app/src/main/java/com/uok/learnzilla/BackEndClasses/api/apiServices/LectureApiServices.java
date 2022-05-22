package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LectureApiServices {
    @GET("/lecture/{lecture_id}")
    Call<apiLectures> getLectureById(@Path("lecture_id") String lecture_id);

    @GET("/lecture/get/course_code={course_code}&academic_year={academic_year}")
    Call<List<apiLectures>> getLecturesByCourse(@Path("course_code")String course_code, @Path("academic_year") String academic_year);

    @POST("/lecture")
    Call<Void>  addLecture(@Body apiLectures lectures);

    @POST("/lecture/delete")
    Call<Void> deleteLecture(@Body apiLectures lectures);

    @POST("/lecture/edit")
    Call<Void> updateLecture(@Body apiLectures lectures);
}

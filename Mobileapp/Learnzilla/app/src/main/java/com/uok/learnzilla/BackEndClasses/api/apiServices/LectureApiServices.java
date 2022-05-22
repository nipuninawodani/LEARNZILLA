package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LectureApiServices {
    @GET("/learnzilla/lecture/{lecture_id}")
    Call<apiLectures> getLectureById(@Path("lecture_id") String lecture_id,@Header("Authorization") String Token);

    @GET("/learnzilla/lecture/get/course_code={course_code}&academic_year={academic_year}")
    Call<List<apiLectures>> getLecturesByCourse(@Path("course_code")String course_code, @Path("academic_year") String academic_year,@Header("Authorization") String Token);

    @POST("/learnzilla/lecture")
    Call<Void>  addLecture(@Body apiLectures lectures,@Header("Authorization") String Token);

    @POST("/learnzilla/lecture/delete")
    Call<Void> deleteLecture(@Body apiLectures lectures,@Header("Authorization") String Token);

    @POST("/learnzilla/lecture/edit")
    Call<Void> updateLecture(@Body apiLectures lectures,@Header("Authorization") String Token);
}

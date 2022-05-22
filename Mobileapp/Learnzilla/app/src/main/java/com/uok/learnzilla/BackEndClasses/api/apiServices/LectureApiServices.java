package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LectureApiServices {
    @GET("/learnzilla/lecture/{lecture_id}?access_token={access_token}")
    Call<apiLectures> getLectureById(@Path("lecture_id") String lecture_id,@Path("access_token") String Token);

    @GET("/learnzilla/lecture/get/course_code={course_code}&academic_year={academic_year}?access_token={access_token}")
    Call<List<apiLectures>> getLecturesByCourse(@Path("course_code")String course_code, @Path("academic_year") String academic_year,@Path("access_token") String Token);

    @POST("/learnzilla/lecture?access_token={access_token}")
    Call<Void>  addLecture(@Body apiLectures lectures,@Path("access_token") String Token);

    @POST("/learnzilla/lecture/delete?access_token={access_token}")
    Call<Void> deleteLecture(@Body apiLectures lectures,@Path("access_token") String Token);

    @POST("/learnzilla/lecture/edit?access_token={access_token}")
    Call<Void> updateLecture(@Body apiLectures lectures,@Path("access_token") String Token);
}

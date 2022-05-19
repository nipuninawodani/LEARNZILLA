package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectureResources;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LectureResourcesApiServices {
    @GET("/lectureResource/lecture_id={lecture_id}")
    Call<List<apiLectureResources>> getLectureResourcesByLectureId(@Path("lecture_id") String lecture_id);

    @POST("/lectureResource")
    Call<apiLectureResources> addLectureResources(@Body apiLectureResources lectureResources);
}

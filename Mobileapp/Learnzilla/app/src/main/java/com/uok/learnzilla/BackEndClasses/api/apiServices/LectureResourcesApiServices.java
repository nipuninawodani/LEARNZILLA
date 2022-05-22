package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectureResources;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LectureResourcesApiServices {
    @GET("/learnzilla/lectureResource/lecture_id={lecture_id}")
    Call<List<apiLectureResources>> getLectureResourcesByLectureId(@Path("lecture_id") Long lecture_id,@Header("Authorization") String Token);

    @POST("/learnzilla/lectureResource")
    Call<Void> addLectureResources(@Body apiLectureResources lectureResources,@Header("Authorization") String Token);

    @POST("/learnzilla/lectureResource/edit")
    Call<Void> UpdateLectureResources(@Body apiLectureResources lectureResource,@Header("Authorization") String Token);

    @POST("/learnzilla/lectureResource/delete")
    Call<Void> DeleteLectureResource(@Body apiLectureResources lectureResource,@Header("Authorization") String Token);

}

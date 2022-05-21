package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectureResources;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LectureResourcesApiServices {
    @GET("/getLectureResource/lecture_id={lecture_id}")
    Call<List<apiLectureResources>> getLectureResourcesByLectureId(@Path("lecture_id") Long lecture_id);

    @POST("/lectureResource")
    Call<Void> addLectureResources(@Body apiLectureResources lectureResources);

    @POST("/lectureResource/edit")
    Call<Void> UpdateLectureResources(@Body apiLectureResources lectureResource);

    @POST("/lectureResource/delete")
    Call<Void> DeleteLectureResource(@Body apiLectureResources lectureResource);

}

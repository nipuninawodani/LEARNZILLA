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
    @GET("/learnzilla/lectureResource/lecture_id={lecture_id}?access_token={access_token}")
    Call<List<apiLectureResources>> getLectureResourcesByLectureId(@Path("lecture_id") Long lecture_id,@Path("access_token") String Token);

    @POST("/learnzilla/lectureResource?access_token={access_token}")
    Call<Void> addLectureResources(@Body apiLectureResources lectureResources,@Path("access_token") String Token);

    @POST("/learnzilla/lectureResource/edit?access_token={access_token}")
    Call<Void> UpdateLectureResources(@Body apiLectureResources lectureResource,@Path("access_token") String Token);

    @POST("/learnzilla/lectureResource/delete?access_token={access_token}")
    Call<Void> DeleteLectureResource(@Body apiLectureResources lectureResource,@Path("access_token") String Token);

}

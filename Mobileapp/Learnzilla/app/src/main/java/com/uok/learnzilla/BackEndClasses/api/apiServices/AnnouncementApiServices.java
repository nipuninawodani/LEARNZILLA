package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiAnnouncement;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AnnouncementApiServices {

    @GET("/learnzilla/announcement/{id}")
    Call<apiAnnouncement> GetAnnouncementByID(@Path("id") Integer id,@Header("Authorization") String Token);

    @GET("/learnzilla/announcement")
    Call<List<apiAnnouncement>> getAllAnnouncement(@Header("Authorization") String Token);

    @GET("/learnzilla/announcement/Get/{course_code}")
    Call<List<apiAnnouncement>> getAnnouncementByCourseCode(@Path("course_code") String course_code,@Header("Authorization") String Token);

    @POST("/learnzilla/announcement")
    Call<Void> addAnnouncement(@Body apiAnnouncement announcement,@Header("Authorization") String Token);
}

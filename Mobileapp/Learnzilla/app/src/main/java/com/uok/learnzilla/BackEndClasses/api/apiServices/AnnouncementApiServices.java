package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiAnnouncement;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AnnouncementApiServices {

    @GET("/learnzilla/announcement/{id}")
    Call<apiAnnouncement> GetAnnouncementByID(@Path("id") Integer id);

    @GET("/learnzilla/announcement")
    Call<List<apiAnnouncement>> getAllAnnouncement();

    @GET("/learnzilla/announcement/Get/{course_code}")
    Call<List<apiAnnouncement>> getAnnouncementByCourseCode(@Path("course_code") String course_code);

    @POST("/learnzilla/announcement")
    Call<Void> addAnnouncement(@Body apiAnnouncement announcement);
}

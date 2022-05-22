package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiAnnouncement;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AnnouncementApiServices {

    @GET("/learnzilla/announcement/{id}?access_token={access_token}")
    Call<apiAnnouncement> GetAnnouncementByID(@Path("id") Integer id,@Path("access_token") String Token);

    @GET("/learnzilla/announcement?access_token={access_token}")
    Call<List<apiAnnouncement>> getAllAnnouncement(@Path("access_token") String Token);

    @GET("/learnzilla/announcement/Get/{course_code}?access_token={access_token}")
    Call<List<apiAnnouncement>> getAnnouncementByCourseCode(@Path("course_code") String course_code,@Path("access_token") String Token);

    @POST("/learnzilla/announcement?access_token={access_token}")
    Call<Void> addAnnouncement(@Body apiAnnouncement announcement,@Path("access_token") String Token);
}

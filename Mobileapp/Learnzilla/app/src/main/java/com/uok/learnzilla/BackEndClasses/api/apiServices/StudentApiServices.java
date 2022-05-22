package com.uok.learnzilla.BackEndClasses.api.apiServices;


import com.uok.learnzilla.BackEndClasses.api.apimodels.apiString;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiStudent;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiToken;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Path;

public interface StudentApiServices {

    @GET("/learnzilla/student/id/{id}?access_token={access_token}")
    Call<apiStudent> getStudentByID(@Path("id") String StudentId,@Path("access_token") String Token);

    @GET("/learnzilla/student/{email}?access_token={access_token}")
    Call<apiStudent> getStudentByEmail(@Path("email") String email,@Path("access_token") String Token);

    @POST("/signup/student")
    Call<apiString> signUpStudent(@Body apiStudent student);

    @POST("/login/student")
    Call<apiToken> LoginStudent(@Body apiStudent student);

}

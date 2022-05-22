package com.uok.learnzilla.BackEndClasses.api.apiServices;


import com.uok.learnzilla.BackEndClasses.api.apimodels.apiStudent;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Path;

public interface StudentApiServices {

    @GET("/learnzilla/student/id/{id}")
    Call<apiStudent> getStudentByID(@Path("id") String StudentId);

    @GET("/learnzilla/student/{email}")
    Call<apiStudent> getStudentByEmail(@Path("email") String email);

    @POST("/signup/student")
    Call<String> signUpStudent(@Body apiStudent student);

    @POST("/login/student")
    Call<?> LoginStudent(@Body apiStudent student);

}

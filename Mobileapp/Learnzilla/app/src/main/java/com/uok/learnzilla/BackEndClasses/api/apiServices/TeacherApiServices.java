package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiString;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiStudent;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiTeacher;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiToken;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TeacherApiServices {
    @GET("/teacher/id/{id}")
    Call<apiTeacher> getTeacherById(@Path("id") String teacherID,@Header("Authorization") String Token);
  
    @GET("/teacher/{email}")
    Call<apiTeacher> getTeacherByEmail(@Path("email") String email,@Header("Authorization") String Token);

    @POST("/signup/teacher")
    Call<apiString> signUpTeacher(@Body apiTeacher teacher);

    @POST("/login/teacher")
    Call<apiToken> LoginTeacher(@Body apiTeacher teacher);
}

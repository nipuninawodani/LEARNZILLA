package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiString;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiStudent;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiTeacher;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiToken;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TeacherApiServices {
    @GET("/teacher/id/{id}?access_token={access_token}")
    Call<apiTeacher> getTeacherById(@Path("id") String teacherID,@Path("access_token") String Token);
  
    @GET("/teacher/{email}?access_token={access_token}")
    Call<apiTeacher> getTeacherByEmail(@Path("email") String email,@Path("access_token") String Token);

    @POST("/signup/teacher")
    Call<apiString> signUpTeacher(@Body apiTeacher teacher);

    @POST("/login/teacher")
    Call<apiToken> LoginTeacher(@Body apiTeacher teacher);
}

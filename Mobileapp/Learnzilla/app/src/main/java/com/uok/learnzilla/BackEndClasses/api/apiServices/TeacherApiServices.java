package com.uok.learnzilla.BackEndClasses.api.apiServices;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiStudent;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiTeacher;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TeacherApiServices {
    @GET("/teacher/id/{id}")
    Call<apiTeacher> getTeacherById(@Path("id") String teacherID);
  
    @GET("/teacher/{email}")
    Call<apiTeacher> getTeacherByEmail(@Path("email") String email);

    @POST("/signup/teacher")
    Call<Void> signUpTeacher(@Body apiTeacher teacher);

}

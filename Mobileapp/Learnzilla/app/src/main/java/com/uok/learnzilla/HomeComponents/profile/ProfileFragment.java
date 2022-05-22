package com.uok.learnzilla.HomeComponents.profile;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.Session.SessionManager;
import com.uok.learnzilla.BackEndClasses.api.apiServices.CourseApiServices;
import com.uok.learnzilla.BackEndClasses.api.apiServices.EnrollmentApiServices;
import com.uok.learnzilla.BackEndClasses.api.apiServices.StudentApiServices;
import com.uok.learnzilla.BackEndClasses.api.apiServices.TeacherApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiEnrollment;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiStudent;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiTeacher;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.HomeComponents.myCoursees.Teacher.MyCoursesTeacherAdapter;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentProfileBinding;

import java.util.List;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    StudentApiServices StudentServices = retrofitConfiguration.getClient().create(StudentApiServices.class);
    EnrollmentApiServices EnrollmentServices = retrofitConfiguration.getClient().create(EnrollmentApiServices.class);
    CourseApiServices CourseService = retrofitConfiguration.getClient().create(CourseApiServices.class);
    TeacherApiServices TeacherServices = retrofitConfiguration.getClient().create(TeacherApiServices.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentProfileBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
        int Type = sharedPreferences.getInt("type",0);
        if(Type == 1){
            addTeacherDetails();
        }else if(Type == 2){
            addStudentDetails();
        }
        getNumberOfCourses();
    }

    private void getNumberOfCourses() {
        SessionManager Manage = new SessionManager(getContext());
        Call<List<apiCourses>> call = CourseService.getAllCourses(Manage.fetchAuthToken());
        call.enqueue(new Callback<List<apiCourses>>() {
            @Override
            public void onResponse(@NonNull Call<List<apiCourses>> call, @NonNull Response<List<apiCourses>> response) {
                int Size = response.body().size();
                if(Size == 0){
                    binding.NoOfCourses.setText("0");
                    binding.EnrolledNumber.setText("0");
                }else {
                    binding.NoOfCourses.setText(String.format("%d",Size));
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<apiCourses>> call, @NonNull Throwable t) {
                new ErrorDialogFragment("Server Error : "+t.getMessage() )
                        .show(getChildFragmentManager(),null);

            }
        });

    }


    private void addStudentDetails() {
        SessionManager Manage = new SessionManager(getContext());
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
        String StudentId = sharedPreferences.getString("ID","");
        binding.type.setText("Student");
        Call<apiStudent> CallStudent = StudentServices.getStudentByID(StudentId,Manage.fetchAuthToken());
        CallStudent.enqueue(new Callback<apiStudent>() {
            @Override
            public void onResponse(Call<apiStudent> call, Response<apiStudent> response) {
                apiStudent student = response.body();
                binding.FirstName.setText(student.getFirstName());
                binding.LastName.setText(student.getLastName());
                binding.Email.setText(student.getEmail());
            }

            @Override
            public void onFailure(Call<apiStudent> call, Throwable t) {
                new ErrorDialogFragment("Server Error : "+t.getMessage() )
                        .show(getChildFragmentManager(),null);
            }
        });
        Call<List<apiEnrollment>> CallEnrolledCourses = EnrollmentServices.getEnrollmentsByStudent(StudentId,Manage.fetchAuthToken());
        CallEnrolledCourses.enqueue(new Callback<List<apiEnrollment>>() {
            @Override
            public void onResponse(Call<List<apiEnrollment>> call, Response<List<apiEnrollment>> response) {
                int Size = response.body().size();
                if(Size == 0){
                    binding.EnrolledNumber.setText("0");
                }else {
                    binding.EnrolledNumber.setText(String.format("%d",Size));
                }
            }

            @Override
            public void onFailure(Call<List<apiEnrollment>> call, Throwable t) {
                new ErrorDialogFragment("Server Error : "+t.getMessage() )
                        .show(getChildFragmentManager(),null);
            }
        });
    }

    private void addTeacherDetails() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
        String TeacherId = sharedPreferences.getString("ID","");
        binding.title3.setText("No Courses you Created");
        binding.type.setText("Teacher");
        SessionManager Manage = new SessionManager(getContext());
        Call<apiTeacher> CallTeacher = TeacherServices.getTeacherById(TeacherId,Manage.fetchAuthToken());
        CallTeacher.enqueue(new Callback<apiTeacher>() {
            @Override
            public void onResponse(Call<apiTeacher> call, Response<apiTeacher> response) {
                apiTeacher teacher = response.body();
                binding.FirstName.setText(teacher.getFirstName());
                binding.LastName.setText(teacher.getLastName());
                binding.Email.setText(teacher.getEmail());
            }

            @Override
            public void onFailure(Call<apiTeacher> call, Throwable t) {
               new ErrorDialogFragment("Server Error : "+t.getMessage() )
                       .show(getChildFragmentManager(),null);

            }
        });
        Call<List<apiCourses>> CallCourse = CourseService.getCourseByTeacherId(TeacherId,Manage.fetchAuthToken());
        CallCourse.enqueue(new Callback<List<apiCourses>>() {
            @Override
            public void onResponse(Call<List<apiCourses>> call, Response<List<apiCourses>> response) {
                int Size = response.body().size();
                if(Size == 0){
                    binding.EnrolledNumber.setText("0");
                }else {
                    binding.EnrolledNumber.setText(String.format("%d",Size));
                }
            }

            @Override
            public void onFailure(Call<List<apiCourses>> call, Throwable t) {
                new ErrorDialogFragment("Server Error : "+t.getMessage() )
                        .show(getChildFragmentManager(),null);
            }
        });
    }


}
package com.uok.learnzilla.HomeComponents.myCoursees.Teacher;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.Session.SessionManager;
import com.uok.learnzilla.BackEndClasses.api.apiServices.CourseApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentMyCoursesTeacherBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMyCoursesTeacher extends Fragment {
    private FragmentMyCoursesTeacherBinding binding;
    CourseApiServices CourseServices = retrofitConfiguration.getClient().create(CourseApiServices.class);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       binding = FragmentMyCoursesTeacherBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.NoData.setVisibility(View.INVISIBLE);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
        String TeacherID = sharedPreferences.getString("ID","");
        SessionManager Manage = new SessionManager(getContext());
        Call<List<apiCourses>> CallCourse = CourseServices.getCourseByTeacherId(TeacherID,Manage.fetchAuthToken());
        CallCourse.enqueue(new Callback<List<apiCourses>>() {
            @Override
            public void onResponse(Call<List<apiCourses>> call, Response<List<apiCourses>> response) {
                if(response.body()== null){

                }else{
                    List<apiCourses> courses = response.body();
                    MyCoursesTeacherAdapter adapter = new MyCoursesTeacherAdapter(courses);
                    binding.recyclerview.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<apiCourses>> call, Throwable t) {
                new ErrorDialogFragment("Server Error :" + t.getMessage())
                        .show(getChildFragmentManager(),null);
            }
        });
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FragmentMyCoursesTeacher.this)
                        .navigate(R.id.action_MyCoursesTeacher_to_AddCourseDialog);
            }
        });


    }
}
package com.uok.learnzilla.HomeComponents.myCoursees.Student;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uok.learnzilla.BackEndClasses.api.apiServices.CourseApiServices;
import com.uok.learnzilla.BackEndClasses.api.apiServices.EnrollmentApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiEnrollment;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.databinding.FragmentMycoursesStudentBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentMyCoursesStudent extends Fragment {
    private FragmentMycoursesStudentBinding binding;
    EnrollmentApiServices EnrollmentServices = retrofitConfiguration.getClient().create(EnrollmentApiServices.class);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMycoursesStudentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        bindDataToRecyclerView();

    }

    private void bindDataToRecyclerView() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
        String StudentId = sharedPreferences.getString("ID","");
        Call<List<apiEnrollment>> CallEnrolledCourses = EnrollmentServices.getEnrollmentsByStudent(StudentId);
        CallEnrolledCourses.enqueue(new Callback<List<apiEnrollment>>() {
            @Override
            public void onResponse(Call<List<apiEnrollment>> call, Response<List<apiEnrollment>> response) {
                List<apiEnrollment> enrollments = response.body();
                MyCoursesStudentAdaptor adaptor = new MyCoursesStudentAdaptor(enrollments);
                binding.recyclerview.setAdapter(adaptor);
            }

            @Override
            public void onFailure(Call<List<apiEnrollment>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                //no data found
            }
        });
    }
}
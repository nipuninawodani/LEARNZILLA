package com.uok.learnzilla.courses.teacher;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.uok.learnzilla.BackEndClasses.api.apiServices.CourseApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentManageCourseDialogBinding;


public class ManageCourseDialogFragment extends DialogFragment {
    private FragmentManageCourseDialogBinding binding;
    CourseApiServices CourseServices = retrofitConfiguration.getClient().create(CourseApiServices.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentManageCourseDialogBinding.inflate(inflater,container,false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiCourses course = ManageCourseDialogFragmentArgs.fromBundle(getArguments()).getCourse();
        binding.DeleteCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Void> Call = CourseServices.DeleteCourse(course);
                Call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(retrofit2.Call<Void> call, Response<Void> response) {
                        Toast.makeText(getContext(), "Course Deleted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(retrofit2.Call<Void> call, Throwable t) {
                        Toast.makeText(getContext(),"Server Error",Toast.LENGTH_SHORT);

                    }
                });

            }
        });
        binding.StudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ManageCourseDialogFragmentDirections.ActionManageCourseDialogToResultViewTeacher Action;
                Action = ManageCourseDialogFragmentDirections.actionManageCourseDialogToResultViewTeacher(course);
                NavHostFragment.findNavController(ManageCourseDialogFragment.this)
                        .navigate(Action);
            }
        });
    }
}
package com.uok.learnzilla.courses.teacher;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uok.learnzilla.BackEndClasses.api.apiServices.LectureApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentAddLectureDialogBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddLectureDialogFragment extends DialogFragment {
    private FragmentAddLectureDialogBinding binding;
    LectureApiServices LectureServices = retrofitConfiguration.getClient().create(LectureApiServices.class);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddLectureDialogBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiCourses course = AddLectureDialogFragmentArgs.fromBundle(getArguments()).getCourse();
        binding.CloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        binding.SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(
                            TextUtils.isEmpty(binding.TitleEdit.getText())
                        ||  TextUtils.isEmpty(binding.WeekEdt.getText())
                ){
                    Toast.makeText(getContext(), "Add Empty Fields", Toast.LENGTH_SHORT).show();
                }else {
                    apiLectures lecture = getDataForLecture(course);
                    Call<Void> CallAddLecture = LectureServices.addLecture(lecture);
                    CallAddLecture.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            Toast.makeText(getContext(), "Lecture Added", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT).show();
                        }
                    });


                }
            }
        });
    }

    private apiLectures getDataForLecture(apiCourses course) {
        String week = binding.WeekEdt.getText().toString();
        String Title = binding.TitleEdit.getText().toString();
        return new apiLectures(course.getAcademic_year(),course.getCourse_code(),Title,week);
    }
}
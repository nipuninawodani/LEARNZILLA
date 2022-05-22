package com.uok.learnzilla.courses.teacher;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.AlartDialogs.SuccessDialogFragment;
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
                        ||  TextUtils.isEmpty(binding.DisEdit.getText())
                ){
                    new ErrorDialogFragment("Fill Empty TextBoxes" )
                            .show(getChildFragmentManager(),null);
                }else {
                    apiLectures lecture = getDataForLecture(course);
                    Call<Void> CallAddLecture = LectureServices.addLecture(lecture);
                    CallAddLecture.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            new SuccessDialogFragment("Lecture added Successfully")
                                    .show(getChildFragmentManager(),null);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    NavHostFragment.findNavController(AddLectureDialogFragment.this)
                                            .navigate(R.id.action_AddLectureDialog_to_MyCoursesTeacher);
                                }
                            }, 10000);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            new ErrorDialogFragment("Server Error :" + t.getMessage())
                                    .show(getChildFragmentManager(),null);
                        }
                    });


                }
            }
        });
    }

    private apiLectures getDataForLecture(apiCourses course) {
        String week = binding.DisEdit.getText().toString();
        String Title = binding.TitleEdit.getText().toString();
        return new apiLectures(course.getAcademic_year(),course.getCourse_code(),week,Title);
    }
}
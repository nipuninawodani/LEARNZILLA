package com.uok.learnzilla.lecture.teacher;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.AlartDialogs.SuccessDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.Session.SessionManager;
import com.uok.learnzilla.BackEndClasses.api.apiServices.LectureApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentUpdateLectureDialogBinding;


public class updateLectureDialogFragment extends DialogFragment {
    private FragmentUpdateLectureDialogBinding binding;
    LectureApiServices LectureServices = retrofitConfiguration.getClient().create(LectureApiServices.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentUpdateLectureDialogBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiLectures lecture = updateLectureDialogFragmentArgs.fromBundle(getArguments()).getLecture();
        binding.TitleEdit.setText(lecture.getTitle());
        binding.DisEdit.setText(lecture.getDescription());
        binding.SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(binding.TitleEdit.getText())||TextUtils.isEmpty(binding.DisEdit.getText())){

                    new ErrorDialogFragment("Fill Empty Text Boxes")
                            .show(getChildFragmentManager(),null);
                }else{
                    apiLectures LectureNew = PutDataToUpdateLecture(lecture);
                    SessionManager Manage = new SessionManager(getContext());
                    Call<Void> CallUpdateLecture = LectureServices.updateLecture(LectureNew,Manage.fetchAuthToken());
                    CallUpdateLecture.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            new SuccessDialogFragment("Lecture added Successfully")
                                    .show(getChildFragmentManager(),null);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    NavHostFragment.findNavController(updateLectureDialogFragment.this)
                                            .navigate(R.id.action_UpdateLectureDialog_to_MyCoursesTeacher);
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

    private apiLectures PutDataToUpdateLecture(apiLectures lecture) {
        String Title = binding.TitleEdit.getText().toString();
        String Des = binding.DisEdit.getText().toString();
        return new apiLectures(lecture.getLectureid(),lecture.getAcademic_year(),lecture.getCourse_code(),Des,Title);
    }
}
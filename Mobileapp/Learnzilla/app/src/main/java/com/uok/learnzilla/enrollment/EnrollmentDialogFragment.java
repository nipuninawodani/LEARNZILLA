package com.uok.learnzilla.enrollment;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.AlartDialogs.SuccessDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.Session.SessionManager;
import com.uok.learnzilla.BackEndClasses.api.apiServices.EnrollmentApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiEnrollment;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;

import com.uok.learnzilla.Login.DialogFragments.RegisterDialogFragment;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentEnrollmentDialogBinding;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EnrollmentDialogFragment extends DialogFragment {
    private FragmentEnrollmentDialogBinding binding;
    EnrollmentApiServices EnrollServices = retrofitConfiguration.getClient().create(EnrollmentApiServices.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEnrollmentDialogBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EnrollViewModel viewModel = EnrollmentDialogFragmentArgs.fromBundle(getArguments()).getEnroll();
        binding.textViewLevel.setText("Level : "+viewModel.courses.getLevel());
        binding.textViewAcademicYear.setText("Academic Year : "+viewModel.courses.getAcademic_year());
        binding.textViewCourseTitle.setText(viewModel.courses.getCourse_code()+"\n"+viewModel.courses.getTitle());
        binding.textViewSemester.setText("Semester :"+viewModel.courses.getSemester());
        binding.textViewCourseTeacher.setText("By "+viewModel.TeacherName);
        binding.closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        binding.EnrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
                int Type = sharedPreferences.getInt("type",0);
                if (Type == 1){
                    new ErrorDialogFragment("Teacher Can't Enroll Courses" )
                            .show(getChildFragmentManager(),null);

                } else if(Type == 2){
                    String StudentId = sharedPreferences.getString("ID","");
                    SessionManager Manage = new SessionManager(getContext());
                    Call<apiEnrollment> CallCheck = EnrollServices.checkEnroll(viewModel.courses.getCourse_code(),viewModel.courses.getAcademic_year(),StudentId,Manage.fetchAuthToken());
                    CallCheck.enqueue(new Callback<apiEnrollment>() {
                        @Override
                        public void onResponse(Call<apiEnrollment> call, Response<apiEnrollment> response) {
                            new ErrorDialogFragment("You Already Enrolled This Course "+viewModel.courses.getCourse_code() )
                                    .show(getChildFragmentManager(),null);
                        }

                        @Override
                        public void onFailure(Call<apiEnrollment> call, Throwable t) {
                            apiEnrollment enrollment = getEnrollmentData(viewModel,StudentId);
                            Call<Void> CallEnrollAdd = EnrollServices.addEnrollment(enrollment,Manage.fetchAuthToken());
                            CallEnrollAdd.enqueue(new Callback<Void>() {
                             @Override
                             public void onResponse(Call<Void> call, Response<Void> response) {
                                 new SuccessDialogFragment("You successfully Enrolled")
                                         .show(getChildFragmentManager(),null);
                             }

                             @Override
                             public void onFailure(Call<Void> call, Throwable t) {
                                 new ErrorDialogFragment("You Can't Enroll at the moment")
                                         .show(getChildFragmentManager(),null);
                             }
                         });
                        }
                    });

                }
            }
        });
    }

    private apiEnrollment getEnrollmentData(EnrollViewModel viewModel, String studentId) {
       String academic_year = viewModel.courses.getAcademic_year();
       String course_code = viewModel.courses.getCourse_code();
       String student_id = studentId;
       String overall_grade = null;
      return  new apiEnrollment(academic_year,course_code,student_id,overall_grade);
    }

}
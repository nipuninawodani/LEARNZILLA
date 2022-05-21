package com.uok.learnzilla.courses.teacher;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.uok.learnzilla.BackEndClasses.api.apiServices.EnrollmentApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiEnrollment;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentUpdateGradeDialogBinding;

public class UpdateGradeDialogFragment extends DialogFragment {
    private FragmentUpdateGradeDialogBinding binding;
    EnrollmentApiServices enrollmentServices = retrofitConfiguration.getClient().create(EnrollmentApiServices.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUpdateGradeDialogBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiEnrollment enrollment = UpdateGradeDialogFragmentArgs.fromBundle(getArguments()).getEnrollment();
        String StudentName = UpdateGradeDialogFragmentArgs.fromBundle(getArguments()).getStudentName();
        binding.StudentNAme.setText(StudentName);
        binding.SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(binding.GradeEdit.getText())){
                    Toast.makeText(getContext(), "Empty Field", Toast.LENGTH_SHORT).show();
                }else {
                    apiEnrollment NewEnrollment = UpdateEnrolmentWithGrade(enrollment);
                    Call<Void> CallUpdate = enrollmentServices.updateEnrollment(NewEnrollment);
                    CallUpdate.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            Toast.makeText(getContext(), "Grade Added", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });
        binding.CloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    private apiEnrollment UpdateEnrolmentWithGrade(apiEnrollment enrollment) {
        enrollment.setOverall_grade(binding.GradeEdit.getText().toString());
        return enrollment;
    }
}
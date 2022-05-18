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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.uok.learnzilla.Login.DialogFragments.RegisterDialogFragment;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentEnrollmentDialogBinding;


public class EnrollmentDialogFragment extends DialogFragment {
    private FragmentEnrollmentDialogBinding binding;

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
                    AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                    builder.setTitle("Warning");
                    builder.setMessage("Teacher Can not Enroll a Course")
                            .setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.cancel());
                    AlertDialog alert = builder.create();
                    alert.show();
                } else if(Type == 2){
                    Toast.makeText(getContext(), "Student Can enroll", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
package com.uok.learnzilla.HomeComponents.myCoursees.Teacher;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.apiServices.CourseApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentAddCourseDialogBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddCourseDialogFragment extends DialogFragment {
    private  FragmentAddCourseDialogBinding binding;
    CourseApiServices ApiCourse = retrofitConfiguration.getClient().create(CourseApiServices.class);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddCourseDialogBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(
                        TextUtils.isEmpty(binding.CourseCodeEdit.getText())
                                ||  TextUtils.isEmpty(binding.TitleCourseEdit.getText())
                                ||  TextUtils.isEmpty(binding.DescriptionEdit.getText())
                                ||  TextUtils.isEmpty(binding.acadamicYearEdit.getText())
                                ||  TextUtils.isEmpty(binding.SemesterEdit.getText())
                                ||  TextUtils.isEmpty(binding.LanguageEdit.getText())
                                ||  TextUtils.isEmpty(binding.LeveleEdit.getText())
                ){
                    new ErrorDialogFragment("Please Fill Empty Fields")
                            .show(getChildFragmentManager(),null);
                }else{
                    apiCourses course = AddDataIntoCourse();
                    Call<Void> CallPostCourse = ApiCourse.addCourse(course);
                    CallPostCourse.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            Toast.makeText(getContext(), "Course Added", Toast.LENGTH_SHORT).show();
                            NavHostFragment.findNavController(AddCourseDialogFragment.this)
                                    .navigate(R.id.action_AddCourseDialog_to_MyCoursesTeacher);
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

    private apiCourses AddDataIntoCourse() {
        String academicYear = binding.acadamicYearEdit.getText().toString();
        String CourseCode = binding.CourseCodeEdit.getText().toString();
        String Title = binding.TitleCourseEdit.getText().toString();
        String Description =  binding.DescriptionEdit.getText().toString();
        String Level = binding.LeveleEdit.getText().toString();
        String Semester = binding.SemesterEdit.getText().toString();
        String Language = binding.LanguageEdit.getText().toString();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
        String TeacherID = sharedPreferences.getString("ID","");
        return new apiCourses(academicYear,CourseCode,Level,Semester,TeacherID,Title,Description,Language);
    }
}
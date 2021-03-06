package com.uok.learnzilla.courses.teacher;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.Session.SessionManager;
import com.uok.learnzilla.BackEndClasses.api.apiServices.LectureApiServices;
import com.uok.learnzilla.BackEndClasses.api.apiServices.TeacherApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiTeacher;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentTeacherCourseViewBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeacherCourseViewFragment extends Fragment {
    private FragmentTeacherCourseViewBinding binding;
    TeacherApiServices TeacherServices =  retrofitConfiguration.getClient().create(TeacherApiServices.class);
    LectureApiServices LectureServices =  retrofitConfiguration.getClient().create(LectureApiServices.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentTeacherCourseViewBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        apiCourses course = TeacherCourseViewFragmentArgs.fromBundle(getArguments()).getCourse();

        binding.textviewCourseCodeLectures.setText(course.getCourse_code());
        binding.textviewCoursenameLectures.setText(course.getTitle());
        binding.Level.setText("Level :"+course.getLevel());
        binding.Sem.setText("Semester :"+course.getSemester());
        binding.AcademicYearText.setText(course.getAcademic_year());
        SessionManager Manage = new SessionManager(getContext());
        Call<apiTeacher> CallTeacher = TeacherServices.getTeacherById(course.getTeacher_id(),Manage.fetchAuthToken());
        CallTeacher.enqueue(new Callback<apiTeacher>() {
            @Override
            public void onResponse(Call<apiTeacher> call, Response<apiTeacher> response) {
                apiTeacher teacher = response.body();
                binding.textviewCourseTeacherLectures.setText("by :"+teacher.getFirstName()+" "+teacher.getLastName());
            }
            @Override
            public void onFailure(Call<apiTeacher> call, Throwable t) {
                new ErrorDialogFragment("Server Error : " + t.getMessage())
                        .show(getChildFragmentManager(),null);
            }
        });
        Call<List<apiLectures>> CallLecture = LectureServices.getLecturesByCourse(course.getCourse_code(),course.getAcademic_year(),Manage.fetchAuthToken());
        CallLecture.enqueue(new Callback<List<apiLectures>>() {
            @Override
            public void onResponse(Call<List<apiLectures>> call, Response<List<apiLectures>> response) {
                    List<apiLectures> lecture = response.body();
                    CourseViewTeacherAdaptor adaptor = new CourseViewTeacherAdaptor(lecture);
                    binding.recyclerview.setAdapter(adaptor);
            }

            @Override
            public void onFailure(Call<List<apiLectures>> call, Throwable t) {
                new ErrorDialogFragment("Server Error : " + t.getMessage())
                        .show(getChildFragmentManager(),null);
            }
        });


        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TeacherCourseViewFragmentDirections.ActionCourseViewLecturesTeacherToAddLectureDialog Action;
                Action = TeacherCourseViewFragmentDirections.actionCourseViewLecturesTeacherToAddLectureDialog(course);
                NavHostFragment.findNavController(TeacherCourseViewFragment.this)
                        .navigate(Action);
            }
        });

        binding.ManageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TeacherCourseViewFragmentDirections.ActionCourseViewLecturesTeacherToManageCourseDialog Action;
                Action = TeacherCourseViewFragmentDirections.actionCourseViewLecturesTeacherToManageCourseDialog(course);
                NavHostFragment.findNavController(TeacherCourseViewFragment.this)
                        .navigate(Action);
            }
        });
    }
}
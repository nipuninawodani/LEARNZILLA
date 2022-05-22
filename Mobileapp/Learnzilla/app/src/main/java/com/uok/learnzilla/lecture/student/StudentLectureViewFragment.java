package com.uok.learnzilla.lecture.student;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.apiServices.LectureResourcesApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectureResources;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.courses.student.StudentCourseViewFragmentDirections;
import com.uok.learnzilla.databinding.FragmentStudentLectureViewBinding;
import com.uok.learnzilla.lecture.teacher.TeacherLectureResourcesAdaptor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentLectureViewFragment extends Fragment {
    private FragmentStudentLectureViewBinding binding;
    LectureResourcesApiServices ResourcesServices = retrofitConfiguration.getClient().create(LectureResourcesApiServices.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentStudentLectureViewBinding.inflate(inflater,container,false);
      return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        apiLectures lecture =StudentLectureViewFragmentArgs.fromBundle(getArguments()).getLecture();
        binding.textviewLecturesDetails.setText(lecture.getTitle()+"\n"+lecture.getDescription());
        Call<List<apiLectureResources>> CallResources = ResourcesServices.getLectureResourcesByLectureId(lecture.getLectureid());
        CallResources.enqueue(new Callback<List<apiLectureResources>>() {
            @Override
            public void onResponse(Call<List<apiLectureResources>> call, Response<List<apiLectureResources>> response) {
                List<apiLectureResources> resources = response.body();
                StuLectureResourcesAdaptor adaptor = new StuLectureResourcesAdaptor(resources);
                binding.recyclerview.setAdapter(adaptor);
            }
            @Override
            public void onFailure(Call<List<apiLectureResources>> call, Throwable t) {

                new ErrorDialogFragment("Server Error :" + t.getMessage())
                        .show(getChildFragmentManager(),null);
            }
        });
    }
}
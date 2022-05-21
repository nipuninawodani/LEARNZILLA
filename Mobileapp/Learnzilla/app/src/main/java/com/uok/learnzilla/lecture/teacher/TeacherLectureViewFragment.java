package com.uok.learnzilla.lecture.teacher;

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
import com.uok.learnzilla.BackEndClasses.api.apiServices.LectureResourcesApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectureResources;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentTeacherLectureViewBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeacherLectureViewFragment extends Fragment {
    private FragmentTeacherLectureViewBinding binding;
    LectureResourcesApiServices ResourcesServices = retrofitConfiguration.getClient().create(LectureResourcesApiServices.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTeacherLectureViewBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiLectures lecture = TeacherLectureViewFragmentArgs.fromBundle(getArguments()).getLecture();
        binding.textviewLecturesDetails.setText(lecture.getTitle()+"\n"+lecture.getDescription());
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        Call<List<apiLectureResources>> CallResources = ResourcesServices.getLectureResourcesByLectureId(lecture.getLectureid());
        CallResources.enqueue(new Callback<List<apiLectureResources>>() {
            @Override
            public void onResponse(Call<List<apiLectureResources>> call, Response<List<apiLectureResources>> response) {
                List<apiLectureResources> resources = response.body();
                TeacherLectureResourcesAdaptor adaptor = new TeacherLectureResourcesAdaptor(resources);
                binding.recyclerview.setAdapter(adaptor);
            }

            @Override
            public void onFailure(Call<List<apiLectureResources>> call, Throwable t) {
                new ErrorDialogFragment("Server Error :" + t.getMessage())
                        .show(getChildFragmentManager(),null);
            }
        });
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TeacherLectureViewFragmentDirections.ActionLectureTeacherViewToAddLectureResourceDialog Action;
                Action = TeacherLectureViewFragmentDirections.actionLectureTeacherViewToAddLectureResourceDialog(lecture);
                NavHostFragment.findNavController(TeacherLectureViewFragment.this)
                        .navigate(Action);
            }
        });

        binding.UpdateLecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TeacherLectureViewFragmentDirections.ActionLectureTeacherViewToUpdateLectureDialog Action;
                apiLectures lecture = TeacherLectureViewFragmentArgs.fromBundle(getArguments()).getLecture();
                Action = TeacherLectureViewFragmentDirections.actionLectureTeacherViewToUpdateLectureDialog(lecture);
                NavHostFragment.findNavController(TeacherLectureViewFragment.this)
                        .navigate(Action);
            }
        });

    }
}
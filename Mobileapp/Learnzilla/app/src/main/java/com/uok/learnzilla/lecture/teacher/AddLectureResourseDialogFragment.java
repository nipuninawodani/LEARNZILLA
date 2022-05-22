package com.uok.learnzilla.lecture.teacher;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.uok.learnzilla.BackEndClasses.api.apiServices.LectureResourcesApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectureResources;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentAddLectureDialogBinding;
import com.uok.learnzilla.databinding.FragmentAddLectureResourseDialogBinding;


public class AddLectureResourseDialogFragment extends DialogFragment {
    private FragmentAddLectureResourseDialogBinding binding;
    LectureResourcesApiServices ResourceServices = retrofitConfiguration.getClient().create(LectureResourcesApiServices.class);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     binding = FragmentAddLectureResourseDialogBinding.inflate(inflater,container,false);
     return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiLectures lecture = AddLectureResourseDialogFragmentArgs.fromBundle(getArguments()).getLecture();
        binding.CloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }


}
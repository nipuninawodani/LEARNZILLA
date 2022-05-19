package com.uok.learnzilla.HomeComponents.myCoursees.Teacher;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentAddCourseDialogBinding;


public class AddCourseDialogFragment extends DialogFragment {
    private  FragmentAddCourseDialogBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddCourseDialogBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

}
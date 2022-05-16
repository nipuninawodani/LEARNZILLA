package com.uok.learnzilla.courses;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentStudentCourseViewBinding;


public class StudentCourseViewFragment extends Fragment {
    private FragmentStudentCourseViewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentStudentCourseViewBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}
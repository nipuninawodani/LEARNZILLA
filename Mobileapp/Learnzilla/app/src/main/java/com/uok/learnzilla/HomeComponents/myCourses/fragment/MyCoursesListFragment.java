package com.uok.learnzilla.HomeComponents.myCourses.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uok.learnzilla.HomeComponents.myCourses.adaptor.MyCoursesListAdapter;
import com.uok.learnzilla.HomeComponents.myCourses.model.Courses;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentMyCoursesListBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MyCoursesListFragment extends Fragment {
     private FragmentMyCoursesListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyCoursesListBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(view.getContext()));
        List<Courses> courses = new ArrayList<Courses>();
        Collections.addAll(
                courses,
                new Courses("SENG50236","Software", "Abdullah"),
                new Courses("SENG50266","Hardware", "mahela"),
                new Courses("SENG50246","Operating System", "shachin"),
                new Courses("SENG50246","Gaming", "Nipuni"),
                new Courses("SENG50246","Studies", "Waruni")
        );
        MyCoursesListAdapter myCoursesListAdapter = new MyCoursesListAdapter(courses);
        binding.recyclerview.setAdapter(myCoursesListAdapter);
    }
}
package com.uok.learnzilla.HomeComponents.allCourses.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.uok.learnzilla.HomeComponents.allCourses.adaptor.AllCourseListAdaptor;
import com.uok.learnzilla.HomeComponents.allCourses.model.Courses;
import com.uok.learnzilla.databinding.FragmentAllCourseListBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class allCourseListFragment extends Fragment {
    private FragmentAllCourseListBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAllCourseListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(view.getContext()));

        //testing Only
        List<Courses> courses = new ArrayList<Courses>();
        Collections.addAll(
                courses,
                new Courses("QENG50236","Software", "Abdullah"),
                new Courses("QENG50266","Hardware", "mahela"),
                new Courses("QENG50246","Operating System", "shachin"),
                new Courses("QENG50246","Gaming", "Nipuni"),
                new Courses("QENG50246","Studies", "Waruni")

        );

        AllCourseListAdaptor allCourseListAdaptor = new AllCourseListAdaptor(courses);
        binding.recyclerview.setAdapter(allCourseListAdaptor);


    }
}
    
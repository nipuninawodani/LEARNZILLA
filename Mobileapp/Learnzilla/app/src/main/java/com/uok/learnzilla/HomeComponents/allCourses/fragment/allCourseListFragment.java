package com.uok.learnzilla.HomeComponents.allCourses.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.Session.SessionManager;
import com.uok.learnzilla.BackEndClasses.api.apiServices.CourseApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.HomeComponents.allCourses.adaptor.AllCourseListAdaptor;
import com.uok.learnzilla.databinding.FragmentAllCourseListBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class allCourseListFragment extends Fragment {
    private FragmentAllCourseListBinding binding;
    CourseApiServices apiService = retrofitConfiguration.getClient().create(CourseApiServices.class);


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAllCourseListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        addToRecyclerView();

    }

    private void addToRecyclerView() {
        SessionManager Manage = new SessionManager(getContext());
        Call<List<apiCourses>> call = apiService.getAllCourses(Manage.fetchAuthToken());
        call.enqueue(new Callback<List<apiCourses>>() {
            @Override
            public void onResponse(@NonNull Call<List<apiCourses>> call, @NonNull Response<List<apiCourses>> response) {
                List<apiCourses> body = response.body();
                AllCourseListAdaptor allCourseListAdaptor = new AllCourseListAdaptor(body);
                binding.recyclerview.setAdapter(allCourseListAdaptor);
            }
            @Override
            public void onFailure(@NonNull Call<List<apiCourses>> call, @NonNull Throwable t) {
                new ErrorDialogFragment("Server Error : "+t.getMessage())
                        .show(getChildFragmentManager(),null);
            }
        });

    }
}
    
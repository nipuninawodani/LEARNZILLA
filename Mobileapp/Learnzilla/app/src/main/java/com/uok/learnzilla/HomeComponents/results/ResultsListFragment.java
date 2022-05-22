package com.uok.learnzilla.HomeComponents.results;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.apiServices.EnrollmentApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiEnrollment;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentResultsListBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ResultsListFragment extends Fragment {

    private FragmentResultsListBinding binding;
    EnrollmentApiServices EnrollServices = retrofitConfiguration.getClient().create(EnrollmentApiServices.class);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentResultsListBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
        String StudentId = sharedPreferences.getString("ID","");
        Call<List<apiEnrollment>> CallEnroll = EnrollServices.getEnrollmentsByStudent(StudentId);
        CallEnroll.enqueue(new Callback<List<apiEnrollment>>() {
            @Override
            public void onResponse(Call<List<apiEnrollment>> call, Response<List<apiEnrollment>> response) {
                List<apiEnrollment> enrollments = response.body();
                ResultsListAdaptor resultsListAdaptor = new ResultsListAdaptor(enrollments);
                binding.recyclerview.setAdapter(resultsListAdaptor);
            }

            @Override
            public void onFailure(Call<List<apiEnrollment>> call, Throwable t) {
                new ErrorDialogFragment("Server Error :" + t.getMessage())
                        .show(getChildFragmentManager(),null);
            }
        });

    }
}
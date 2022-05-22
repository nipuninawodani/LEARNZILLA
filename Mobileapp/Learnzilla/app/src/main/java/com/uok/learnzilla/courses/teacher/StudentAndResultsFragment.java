package com.uok.learnzilla.courses.teacher;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.apiServices.EnrollmentApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiEnrollment;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.databinding.FragmentStudentAndResultsBinding;

import java.util.List;

public class StudentAndResultsFragment extends Fragment {
    private FragmentStudentAndResultsBinding binding;
    SwipeRefreshLayout swipeRefreshLayout;
    EnrollmentApiServices EnrollmentServices = retrofitConfiguration.getClient().create(EnrollmentApiServices.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentStudentAndResultsBinding.inflate(inflater,container,false);
      return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addtoRecyclerView();
        swipeRefreshLayout = binding.Scroll;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                addtoRecyclerView();
            }
        });

    }

    private void addtoRecyclerView() {
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        apiCourses course = StudentAndResultsFragmentArgs.fromBundle(getArguments()).getCourse();
        Call<List<apiEnrollment>> CallStudents = EnrollmentServices.getEnrollmentsByCourse(course.getCourse_code(),course.getAcademic_year());
        CallStudents.enqueue(new Callback<List<apiEnrollment>>() {
            @Override
            public void onResponse(Call<List<apiEnrollment>> call, Response<List<apiEnrollment>> response) {
                if(response.body().size() == 0) {
                    new ErrorDialogFragment("No Enrolled Student found..!")
                            .show(getChildFragmentManager(),null);
                }else {
                    List<apiEnrollment> enrollments = response.body();
                    StudentsAndResultsAdaptor adaptor = new StudentsAndResultsAdaptor(enrollments);
                    binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
                    binding.recyclerview.setAdapter(adaptor);
                }
            }

            @Override
            public void onFailure(Call<List<apiEnrollment>> call, Throwable t) {
                new ErrorDialogFragment("Server Error : "+t.getMessage())
                        .show(getChildFragmentManager(),null);
            }
        });
    }


}
package com.uok.learnzilla.Home;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.uok.learnzilla.Login.Activities.LoginActivity;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());

        binding.Logout.setOnClickListener(view1 -> {
            builder.setTitle("Logout");
            builder.setMessage("Do you need to logout your account")
                    .setCancelable(false)
                    .setPositiveButton("yes",(dialogInterface, i) -> {
                        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("Login",false);
                        editor.apply();
                        goToLoginActivity();
                    })
                    .setNegativeButton("No",(dialogInterface, i) -> dialogInterface.cancel());
            AlertDialog alert = builder.create();
            alert.show();

        });

        binding.AllCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_HomeFragment_to_AllCourses);
            }
        });
        binding.MyCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
                int Type = sharedPreferences.getInt("type",0);
                if(Type == 1){
                    NavHostFragment.findNavController(HomeFragment.this)
                            .navigate(R.id.action_HomeFragment_to_MyCoursesTeacher);
                }if(Type == 2){
                    NavHostFragment.findNavController(HomeFragment.this)
                            .navigate(R.id.action_HomeFragment_to_MyCoursesStudent);
                }
            }
        });
        binding.Results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_HomeFragment_to_Results);
            }

        });
        binding.Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
    }

    private void goToLoginActivity() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

}
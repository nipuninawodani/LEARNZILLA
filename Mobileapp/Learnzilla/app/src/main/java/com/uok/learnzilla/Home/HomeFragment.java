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

import com.uok.learnzilla.Login.Activities.LoginActivity;
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

        binding.LogOutButton.setOnClickListener(view1 -> {
            builder.setTitle("Logout");
            builder.setMessage("Do you need to logout your account")
                    .setCancelable(false)
                    .setPositiveButton("yes",(dialogInterface, i) -> {
                        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("Login",false);
                        editor.apply();
                        goToLoginActivityt();
                    })
                    .setNegativeButton("No",(dialogInterface, i) -> dialogInterface.cancel());
            AlertDialog alert = builder.create();
            alert.show();


        });
    }

    private void goToLoginActivityt() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

}
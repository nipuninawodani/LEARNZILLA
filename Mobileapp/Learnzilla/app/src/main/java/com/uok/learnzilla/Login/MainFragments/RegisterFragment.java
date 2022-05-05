package com.uok.learnzilla.Login.MainFragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;

    public RegisterFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int RegisterArg = RegisterFragmentArgs.fromBundle(getArguments()).getRegister();
        if (RegisterArg == 1){
            binding.registerTitle.setText("Student Register");
        }
        if (RegisterArg == 2){
            binding.registerTitle.setText("Teacher Register");
        }

        binding.SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (RegisterArg == 1){
                   RegisterStudent();
                   NavHostFragment.findNavController(RegisterFragment.this)
                           .navigate(R.id.action_RegisterFragment_to_LoginFragment);
               }
               if (RegisterArg == 2){
                   RegisterTeacher();
                   NavHostFragment.findNavController(RegisterFragment.this)
                           .navigate(R.id.action_RegisterFragment_to_LoginFragment);
               }
            }
        });

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RegisterFragment.this)
                        .navigate(R.id.action_RegisterFragment_to_LoginFragment);
            }
        });
    }

    //add Register Teacher Program
    private void RegisterTeacher() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setTitle("Register Teacher");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);

        new Thread(new Runnable() {
            public void run() {
                try {
                   //Add Register
                    Looper.prepare();
                    Toast.makeText(getContext(), "Registration Completed", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();

    }

    //add Register Student Program
    private void RegisterStudent() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setTitle("Register Student");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);

        new Thread(new Runnable() {
            public void run() {
                try {
                    //Add Register
                    Looper.prepare();
                    Toast.makeText(getContext(), "Registration Completed", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();

    }
}
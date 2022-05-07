package com.uok.learnzilla.Login.MainFragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Looper;
import android.text.TextUtils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.uok.learnzilla.BackEndClasses.ConfirmPasswordValidator;
import com.uok.learnzilla.BackEndClasses.EmailPatternValidator;

import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;


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

                boolean Empty = false;
                binding.textInputFirstName.setError(null);
                binding.textInputFirstName.setError(null);
                binding.textInputFirstName.setError(null);
                binding.textInputFirstName.setError(null);
                binding.textInputFirstName.setError(null);
                //check Empty
                //FirstNAme
                if(TextUtils.isEmpty(binding.editTextFirstName.getText().toString())){
                    binding.textInputFirstName.setError("Error:first name Can't be empty");
                    return;
                }
                //lastName
                if(TextUtils.isEmpty(binding.editTextLastName.getText().toString())){
                    binding.textInputLastName.setError("Error:lastname Can't be empty");
                    return;
                }
                //Email
                if(TextUtils.isEmpty(binding.editTextEmail.getText().toString())){
                    binding.textInputEmail.setError("Error:Email Can't be empty");
                    return;
                }
                //password
                if(TextUtils.isEmpty(binding.editTextPassword.getText().toString())){
                    binding.textInputPassword.setError("Error:password Can't be empty");
                    return;
                }

                //confirm password
                if(TextUtils.isEmpty(binding.editTextConfirmPassword.getText().toString())){
                    binding.textInputConfirmPassword.setError("Error:Confirm password can't be empty");
                    return;
                }

                //validate Email patten
                EmailPatternValidator EValidator = new EmailPatternValidator();
                boolean validMail = EValidator.isEmailValid(binding.editTextEmail.getText().toString());
                if(!validMail){
                    binding.textInputEmail.setError("Error:Wrong Mail Format, please check");
                    return;
                }

                //Confirm Password Check
                ConfirmPasswordValidator CPValidator = new ConfirmPasswordValidator();
                String cPass = binding.editTextConfirmPassword.getText().toString();
                String pass = binding.editTextPassword.getText().toString();
                if(CPValidator.validateConfirmPassword(pass,cPass)){
                    binding.textInputConfirmPassword.setError("Error : Not matching with password");
                    return;
                }
                //all pass registration
               if (RegisterArg == 1){
                   RegisterStudent();
               }
               if (RegisterArg == 2){
                   RegisterTeacher();

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
                    NavHostFragment.findNavController(RegisterFragment.this)
                            .navigate(R.id.action_RegisterFragment_to_LoginFragment);

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
                    NavHostFragment.findNavController(RegisterFragment.this)
                            .navigate(R.id.action_RegisterFragment_to_LoginFragment);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();

    }
}
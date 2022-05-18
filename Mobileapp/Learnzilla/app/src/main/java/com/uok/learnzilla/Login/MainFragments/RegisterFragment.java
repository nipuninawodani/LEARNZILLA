package com.uok.learnzilla.Login.MainFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.uok.learnzilla.BackEndClasses.api.apiServices.StudentApiServices;
import com.uok.learnzilla.BackEndClasses.api.apiServices.TeacherApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiStudent;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiTeacher;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.BackEndClasses.validaters.ConfirmPasswordValidator;
import com.uok.learnzilla.BackEndClasses.validaters.EmailPatternValidator;

import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentRegisterBinding;

import org.apache.commons.codec.digest.DigestUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;
    TeacherApiServices ApiTeacher = retrofitConfiguration.getClient().create(TeacherApiServices.class);
    StudentApiServices ApiStudent = retrofitConfiguration.getClient().create(StudentApiServices.class);

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
                binding.textInputLastName.setError(null);
                binding.textInputEmail.setError(null);
                binding.textInputPassword.setError(null);
                binding.textInputConfirmPassword.setError(null);
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

                if(!CPValidator.validateConfirmPassword(pass,cPass)){
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
        Call<apiTeacher> callEmail = ApiTeacher.getTeacherByEmail(binding.editTextEmail.getText().toString());
        callEmail.enqueue(new Callback<apiTeacher>() {
            @Override
            public void onResponse(Call<apiTeacher> call, Response<apiTeacher> response) {
                String Error = new String("Email Already Taken..!");
                RegisterFragmentDirections.ActionRegisterFragmentToRegisterFailed action;
                action = RegisterFragmentDirections.actionRegisterFragmentToRegisterFailed(Error);

                NavHostFragment.findNavController(RegisterFragment.this)
                        .navigate(action);
            }

            @Override
            public void onFailure(Call<apiTeacher> call, Throwable t) {
                Call<apiStudent> callEmailStudent = ApiStudent.getStudentByEmail(binding.editTextEmail.getText().toString());
                callEmailStudent.enqueue(new Callback<apiStudent>() {
                    @Override
                    public void onResponse(Call<apiStudent> call, Response<apiStudent> response) {
                        String Error = new String("Email Already Taken..!");
                        RegisterFragmentDirections.ActionRegisterFragmentToRegisterFailed action;
                        action = RegisterFragmentDirections.actionRegisterFragmentToRegisterFailed(Error);

                        NavHostFragment.findNavController(RegisterFragment.this)
                                .navigate(action);
                    }

                    @Override
                    public void onFailure(Call<apiStudent> call, Throwable t) {
                        apiTeacher teacher = getSignInDataTeacher();
                        Call<Void> RegisterCall = ApiTeacher.signUpTeacher(teacher);
                        RegisterCall.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                RegisterFragmentDirections.ActionRegisterFragmentToRegisterSuccess action;
                                action = RegisterFragmentDirections.actionRegisterFragmentToRegisterSuccess(2);
                                NavHostFragment.findNavController(RegisterFragment.this)
                                        .navigate(action);

                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                String Error = new String("Register Failed...! "+t.getMessage());
                                RegisterFragmentDirections.ActionRegisterFragmentToRegisterFailed action;
                                action = RegisterFragmentDirections.actionRegisterFragmentToRegisterFailed(Error);
                                NavHostFragment.findNavController(RegisterFragment.this)
                                        .navigate(action);
                            }
                        });
                    }
                });

            }
        });

    }



    //add Register Student Program
    private void RegisterStudent() {
        Call<apiStudent> EmailCall = ApiStudent.getStudentByEmail(binding.editTextEmail.getText().toString());
        EmailCall.enqueue(new Callback<apiStudent>() {
            @Override
            public void onResponse(Call<apiStudent> call, Response<apiStudent> response) {
                String Error = new String("Email Already Taken..!");
                RegisterFragmentDirections.ActionRegisterFragmentToRegisterFailed action;
                action = RegisterFragmentDirections.actionRegisterFragmentToRegisterFailed(Error);

                NavHostFragment.findNavController(RegisterFragment.this)
                        .navigate(action);
            }

            @Override
            public void onFailure(Call<apiStudent> call, Throwable t) {
                Call<apiTeacher> callEmailTeacher = ApiTeacher.getTeacherByEmail(binding.editTextEmail.getText().toString());
                callEmailTeacher.enqueue(new Callback<apiTeacher>() {
                    @Override
                    public void onResponse(Call<apiTeacher> call, Response<apiTeacher> response) {
                        String Error = new String("Email Already Taken..!");
                        RegisterFragmentDirections.ActionRegisterFragmentToRegisterFailed action;
                        action = RegisterFragmentDirections.actionRegisterFragmentToRegisterFailed(Error);

                        NavHostFragment.findNavController(RegisterFragment.this)
                                .navigate(action);
                    }

                    @Override
                    public void onFailure(Call<apiTeacher> call, Throwable t) {
                        apiStudent student = getSignInDataStudent();
                        Call<Void> RegisterCall = ApiStudent.signupStudent(student);
                        RegisterCall.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                RegisterFragmentDirections.ActionRegisterFragmentToRegisterSuccess action;
                                action = RegisterFragmentDirections.actionRegisterFragmentToRegisterSuccess(2);
                                NavHostFragment.findNavController(RegisterFragment.this)
                                        .navigate(action);
                            }
                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                String Error = new String("Register Failed...! "+t.getMessage());
                                RegisterFragmentDirections.ActionRegisterFragmentToRegisterFailed action;
                                action = RegisterFragmentDirections.actionRegisterFragmentToRegisterFailed(Error);
                                NavHostFragment.findNavController(RegisterFragment.this)
                                        .navigate(action);
                            }
                        });
                    }
                });
            }
        });
    }

    private apiTeacher getSignInDataTeacher() {
        String FirstName = binding.editTextFirstName.getText().toString();
        String LastName = binding.editTextLastName.getText().toString();
        String Email = binding.editTextEmail.getText().toString();
        String Password = DigestUtils.md5Hex(binding.editTextPassword.getText().toString());
        return  new apiTeacher(FirstName,LastName,Email,Password);
    }

    private apiStudent getSignInDataStudent() {
        String FirstName = binding.editTextFirstName.getText().toString();
        String LastName = binding.editTextLastName.getText().toString();
        String Email = binding.editTextEmail.getText().toString();
        String Password = DigestUtils.md5Hex(binding.editTextPassword.getText().toString());
        return  new apiStudent(FirstName,LastName,Email,Password);
    }
}
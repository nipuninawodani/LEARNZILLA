package com.uok.learnzilla.Login.MainFragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.uok.learnzilla.BackEndClasses.api.Session.SessionManager;
import com.uok.learnzilla.BackEndClasses.api.apiServices.StudentApiServices;
import com.uok.learnzilla.BackEndClasses.api.apiServices.TeacherApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiStudent;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiTeacher;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiToken;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.BackEndClasses.validaters.EmailPatternValidator;

import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentLoginBinding;

import org.apache.commons.codec.digest.DigestUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class loginFragment extends Fragment {
    private FragmentLoginBinding binding;

    TeacherApiServices TeacherServices = retrofitConfiguration.getClient().create(TeacherApiServices.class);
    StudentApiServices StudentServices = retrofitConfiguration.getClient().create(StudentApiServices.class);


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.register.setOnClickListener(view1 -> NavHostFragment.findNavController(loginFragment.this)
                .navigate(R.id.action_LoginFragment_to_RegisterDialog));

        binding.cirLoginButton.setOnClickListener(view12 -> {

            binding.textInputEmail.setError(null);
            binding.textInputPassword.setError(null);

            //check is Email EditText Empty
            if(TextUtils.isEmpty(binding.editTextEmail.getText().toString())){
                binding.textInputEmail.setError("Error:Email Can't be empty");
                return;
            }

            //Validate Email Patten
            EmailPatternValidator EValidator = new EmailPatternValidator();
            boolean validMail = EValidator.isEmailValid(binding.editTextEmail.getText().toString());
            if(!validMail){
                binding.textInputEmail.setError("Error:Wrong Mail Format, please check");
                return;
            }


            //check is Password EditText is Empty
            if(TextUtils.isEmpty(binding.editTextPassword.getText().toString())){
                binding.textInputPassword.setError("Error:It's an Empty Password");
                return;
            }
            //all pass  try to login
            LoginMethod();
        });
    }



    //login
    private void LoginMethod() {
       //tryToLoginTeacher
        apiTeacher teacher = new apiTeacher(binding.editTextEmail.getText().toString(),binding.editTextPassword.getText().toString());
        Call<apiToken> CallLogin = TeacherServices.LoginTeacher(teacher);
        CallLogin.enqueue(new Callback<apiToken>() {
            @Override
            public void onResponse(Call<apiToken> call, Response<apiToken> response) {
                apiToken token = response.body();
                Log.e("token",token.getToken());
                SessionManager Manage = new SessionManager(getContext());
                Manage.saveToken(token.getToken());
                Call<apiStudent> CallStudent = StudentServices.getStudentByEmail(binding.editTextEmail.getText().toString(),Manage.fetchAuthToken());
                CallStudent.enqueue(new Callback<apiStudent>() {
                    @Override
                    public void onResponse(Call<apiStudent> call, Response<apiStudent> response) {
                        if(response.body() == null){
                            //teacher
                            Call<apiTeacher> CallTeacher = TeacherServices.getTeacherByEmail(binding.editTextEmail.getText().toString(),Manage.fetchAuthToken());
                            CallTeacher.enqueue(new Callback<apiTeacher>() {
                                @Override
                                public void onResponse(Call<apiTeacher> call, Response<apiTeacher> response) {
                                    if(response.body() == null){

                                    }else {
                                        apiTeacher teacher1 = response.body();
                                        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putBoolean("Login", true);
                                        editor.putInt("type",1);
                                        editor.putString("ID",teacher1.getId());
                                        editor.apply();
                                    }
                                }

                                @Override
                                public void onFailure(Call<apiTeacher> call, Throwable t) {

                                }
                            });
                        }else{
                            apiStudent student = response.body();
                            SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("Login", true);
                            editor.putInt("type",2);
                            editor.putString("ID",student.getId());
                            editor.apply();
                        }
                    }

                    @Override
                    public void onFailure(Call<apiStudent> call, Throwable t) {
                        String Error = t.getMessage();
                        loginFragmentDirections.ActionLoginFragmentToLoginFailed Action;
                        Action=loginFragmentDirections.actionLoginFragmentToLoginFailed(Error);
                        NavHostFragment.findNavController(loginFragment.this)
                                .navigate(Action);
                    }
                });

                loginFragmentDirections.ActionLoginFragmentToLoginSuccess Action;
                Action = loginFragmentDirections.actionLoginFragmentToLoginSuccess(1);
                NavHostFragment.findNavController(loginFragment.this)
                        .navigate(Action);
            }

            @Override
            public void onFailure(Call<apiToken> call, Throwable t) {
                String Error = t.getMessage();
                loginFragmentDirections.ActionLoginFragmentToLoginFailed Action;
                Action=loginFragmentDirections.actionLoginFragmentToLoginFailed(Error);
                NavHostFragment.findNavController(loginFragment.this)
                        .navigate(Action);
            }
        });
    }

    private boolean authanticateUser(String password, String InputPassword) {
        String MD5Pass = DigestUtils.md5Hex(InputPassword);
        Log.e("Pass",MD5Pass);
        Log.e("Pass1",password);
        if(MD5Pass.equals(password)){
            return true;
        }else{
            return false;
        }
    }

}
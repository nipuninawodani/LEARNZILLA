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

import com.uok.learnzilla.BackEndClasses.api.apiServices.StudentApiServices;
import com.uok.learnzilla.BackEndClasses.api.apiServices.TeacherApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiStudent;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiTeacher;
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
        Call<apiTeacher> EmailCall = TeacherServices.getTeacherByEmail(binding.editTextEmail.getText().toString());
        EmailCall.enqueue(new Callback<apiTeacher>() {
            @Override
            public void onResponse(Call<apiTeacher> call, Response<apiTeacher> response) {
                apiTeacher teacher = response.body();
              boolean pass =  authanticateUser(teacher.getPassword(),binding.editTextPassword.getText().toString());
              Log.i("Test",String.format("%b",pass));
                if(pass == true){
                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("Login", true);
                    editor.putInt("type",1);
                    editor.putString("ID",teacher.getId());
                    editor.apply();
                    loginFragmentDirections.ActionLoginFragmentToLoginSuccess Action;
                    Action = loginFragmentDirections.actionLoginFragmentToLoginSuccess(1);
                    NavHostFragment.findNavController(loginFragment.this)
                            .navigate(Action);
                }else {
                    String Error = new String("Password not match");
                    loginFragmentDirections.ActionLoginFragmentToLoginFailed Action;
                    Action=loginFragmentDirections.actionLoginFragmentToLoginFailed(Error);
                    NavHostFragment.findNavController(loginFragment.this)
                            .navigate(Action);
                }

            }

            @Override
            public void onFailure(Call<apiTeacher> call, Throwable t) {
                //tryStudentLogin
                Call<apiStudent> EmailCallStudent = StudentServices.getStudentByEmail(binding.editTextEmail.getText().toString());
                EmailCallStudent.enqueue(new Callback<apiStudent>() {
                    @Override
                    public void onResponse(Call<apiStudent> call, Response<apiStudent> response) {
                        apiStudent student = response.body();
                        boolean pass =  authanticateUser(student.getPassword(),binding.editTextPassword.getText().toString());
                        if(pass == true){
                            SharedPreferences sharedPreferences = getContext().getSharedPreferences("login", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("Login", true);
                            editor.putInt("type",2);
                            editor.putString("ID",student.getId());
                            editor.apply();
                            loginFragmentDirections.ActionLoginFragmentToLoginSuccess Action;
                            Action = loginFragmentDirections.actionLoginFragmentToLoginSuccess(1);
                            NavHostFragment.findNavController(loginFragment.this)
                                    .navigate(Action);
                        }else {
                            String Error = new String("Password not match");
                            loginFragmentDirections.ActionLoginFragmentToLoginFailed Action;
                            Action=loginFragmentDirections.actionLoginFragmentToLoginFailed(Error);
                            NavHostFragment.findNavController(loginFragment.this)
                                    .navigate(Action);
                        }
                    }
                    @Override
                    public void onFailure(Call<apiStudent> call, Throwable t) {
                        String Error = new String("Email not found");
                        loginFragmentDirections.ActionLoginFragmentToLoginFailed Action;
                        Action=loginFragmentDirections.actionLoginFragmentToLoginFailed(Error);
                        NavHostFragment.findNavController(loginFragment.this)
                                .navigate(Action);
                    }
                });
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
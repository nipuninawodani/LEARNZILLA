package com.uok.learnzilla.Login.MainFragments;

import static android.content.Context.MODE_PRIVATE;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.uok.learnzilla.BackEndClasses.EmailPatternValidator;
import com.uok.learnzilla.Home.HomeActivity;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentLoginBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class loginFragment extends Fragment {
    private FragmentLoginBinding binding;

    public loginFragment() {
        // Required empty public constructor
    }


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

            //all pass F try to login
                LoginMethod();

        });
    }

    private void goToHomeActivity() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }



    //login
    private void LoginMethod() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setTitle("Log In");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);

        new Thread(() -> {
            try {
                //Add Login
                //save login
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("Login",true);
                editor.apply();
                Looper.prepare();
                Toast.makeText(getContext(), "Login Completed", Toast.LENGTH_SHORT).show();
                goToHomeActivity();
            } catch (Exception e) {
                e.printStackTrace();
            }
            progressDialog.dismiss();
        }).start();
    }

}
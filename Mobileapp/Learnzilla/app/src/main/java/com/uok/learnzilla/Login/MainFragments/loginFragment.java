package com.uok.learnzilla.Login.MainFragments;

import static android.content.Context.MODE_PRIVATE;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.uok.learnzilla.Home.HomeActivity;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentLoginBinding;


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
            LoginMethod();
            goToHomeActivity();
        });
    }

    private void goToHomeActivity() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);


    }


    private void LoginMethod() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setTitle("Log In");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);

        new Thread(() -> {
            try {
                //save login
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("Login",true);
                editor.apply();
                //Add Login
                Looper.prepare();
                Toast.makeText(getContext(), "Login Completed", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            progressDialog.dismiss();
        }).start();
    }
}
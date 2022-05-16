package com.uok.learnzilla.Login.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.uok.learnzilla.Home.HomeActivity;
import com.uok.learnzilla.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        boolean bLogin = sharedPreferences.getBoolean("Login",false);


        if(bLogin){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else{
            setContentView(R.layout.activity_login);
        }

    }
}
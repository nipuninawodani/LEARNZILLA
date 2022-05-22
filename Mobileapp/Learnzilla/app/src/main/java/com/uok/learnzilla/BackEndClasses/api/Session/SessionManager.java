package com.uok.learnzilla.BackEndClasses.api.Session;


import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public  class SessionManager {
    private Context context;
    private SharedPreferences shardPre ;

    public SessionManager(Context context) {
        this.context = context;
        shardPre=context.getSharedPreferences("Session", MODE_PRIVATE);
    }

   public void saveToken(String Token){
       SharedPreferences.Editor editor = shardPre.edit();
       editor.putString("Token",Token);
       editor.apply();
   }
    public String fetchAuthToken(){
       String Token = shardPre.getString("Token","");
       return Token;
    }
}

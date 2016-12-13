package com.vibsbro.signupandloginexp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by root on 12/12/16.
 */

public class Session {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    Session(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("myapp",context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLogIn(boolean logIn){

        editor.putBoolean("LogedIN",logIn);
        editor.commit();
    }

    public boolean logedIn(){

        return sharedPreferences.getBoolean("LogedIN" ,false);
    }
}

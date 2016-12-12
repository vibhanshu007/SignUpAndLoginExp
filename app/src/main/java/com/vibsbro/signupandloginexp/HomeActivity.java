package com.vibsbro.signupandloginexp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {


    private Session session;
    private Button button_logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        session = new Session(this);
        if (!session.logedIn()){
            logOut();
        }
        button_logOut = (Button) findViewById(R.id.logout_button);
        button_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });

    }

    public void logOut(){
        session.setLogIn(false);
        finish();
        startActivity(new Intent(HomeActivity.this,MainActivity.class));
    }
}

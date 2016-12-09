package com.vibsbro.signupandloginexp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SingUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText singup_name,singup_email,singup_password;
    private Button singup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        singup_name = (EditText) findViewById(R.id.signup_name);
        singup_email = (EditText) findViewById(R.id.signup_email);
        singup_password = (EditText) findViewById(R.id.singup_password);
        singup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.sinup_button:

                break;
            default:
        }
    }
}

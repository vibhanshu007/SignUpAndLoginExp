package com.vibsbro.signupandloginexp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int REQUEST_SIGNUP = 0;

    private EditText user_id, password;
    private Button login_button;
    private TextView sign_up_link;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_button = (Button) findViewById(R.id.button_login);
        sign_up_link = (TextView) findViewById(R.id.linkSingUp);
        user_id = (EditText) findViewById(R.id.input_user_name);
        password = (EditText) findViewById(R.id.input_password);

        login_button.setOnClickListener(this);
        sign_up_link.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.button_login:

                break;

            case R.id.linkSingUp:

                Intent intent = new Intent(getApplicationContext(), SingUpActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);

                break;
            default:
        }

    }
}

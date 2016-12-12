package com.vibsbro.signupandloginexp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SingUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText singup_name,singup_email,singup_password;
    private Button singup;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DbHelper(this);
        singup_name = (EditText) findViewById(R.id.signup_name);
        singup_email = (EditText) findViewById(R.id.signup_email);
        singup_password = (EditText) findViewById(R.id.singup_password);
        setContentView(R.layout.activity_sing_up);
        singup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.sinup_button:
                register();
                break;
            default:
        }
    }

    private void register(){
        String email = singup_email.getText().toString();
        String pass = singup_password.getText().toString();

        if (email.isEmpty() && pass.isEmpty()){
           displayToast("Email or Password is Empty");
        }else {
            dbHelper.addUser(email,pass);
            displayToast("User Registered");
            finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}

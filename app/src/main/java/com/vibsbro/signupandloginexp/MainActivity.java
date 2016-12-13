package com.vibsbro.signupandloginexp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int REQUEST_SIGNUP = 0;

    private EditText et_email, et_password;
    private Button login_button;
    private TextView sign_up_link;
    private DbHelper dbHelper;
    private Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);
        session = new Session(getApplicationContext());
        login_button = (Button) findViewById(R.id.button_login);
        sign_up_link = (TextView) findViewById(R.id.linkSingUp);
        et_email = (EditText) findViewById(R.id.input_user_name);
        et_password = (EditText) findViewById(R.id.input_password);

        login_button.setOnClickListener(this);
        sign_up_link.setOnClickListener(this);

        if (session.logedIn()){
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.button_login:
                login();
                break;

            case R.id.linkSingUp:

                Intent intent = new Intent(MainActivity.this, SingUpActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);

                break;
            default:
        }

    }

    private void login(){
        String email = et_email.getText().toString();
        String pass = et_password.getText().toString();
        //session.setLogIn(true);
        if (dbHelper.getUser(email,pass)){
            Log.e("@@@@@@@@@@@@@","@@@@@@@@");
            session.setLogIn(true);
            startActivity(new Intent (MainActivity.this,HomeActivity.class));
            finish();
        }else {
            Toast.makeText(getApplication(),"Worng Email or Password ",Toast.LENGTH_SHORT).show();
        }
    }


}

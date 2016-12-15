package com.vibsbro.signupandloginexp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.vibsbro.signupandloginexp.fragments.AndroidFragment;
import com.vibsbro.signupandloginexp.fragments.HomeFragment;
import com.vibsbro.signupandloginexp.fragments.JavaFragment;

public class HomeActivity extends AppCompatActivity {


    private Session session;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private Button button_logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        //actionBar.setHomeAsUpIndicator();
        actionBar.setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_home);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);

        if(navigationView != null){

            setupNavigationDrawerContent(navigationView);
        }

        // TODO: 15/12/16 this is session code
        session = new Session(getApplicationContext());
        if (!session.logedIn()){
            logOut();
        }
        //button_logOut = (Button) findViewById(R.id.logout_button);
        /*button_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });*/
    }

    public void logOut(){
        session.setLogIn(false);
        finish();
        startActivity(new Intent(HomeActivity.this,MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            // TODO: 15/12/16 start....from....here.. 
        }
        return true;
    }

    private void setupNavigationDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu_home:
                        item.setChecked(true);
                        setFragment(0);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.menu_android:
                        item.setChecked(true);
                        setFragment(1);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.menu_java:
                        item.setChecked(true);
                        setFragment(2);
                        drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });
    }

    public void setFragment(int position){
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (position){

            case 0:
                HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragment_home,homeFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                AndroidFragment androidFragment = new AndroidFragment();
                fragmentTransaction.replace(R.id.fragment_android,androidFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                JavaFragment javaFragment = new JavaFragment();
                fragmentTransaction.replace(R.id.fragment_java,javaFragment);
                fragmentTransaction.commit();
                break;

        }
    }
}

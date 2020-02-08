package com.project.moverskeletalapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /* @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
     }

     // Button to go to the Login/reg page from the splash screen
     public void buttonToLogin(View view){
         Intent intent = new Intent(this, LoginRegActivity.class);
         startActivity(intent);

     }
 }*/
    private static int SPLASH_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(MainActivity.this, LoginRegActivity.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME);
    }
}
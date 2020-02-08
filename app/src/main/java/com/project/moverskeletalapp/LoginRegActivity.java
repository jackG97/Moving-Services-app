package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class LoginRegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reg);
    }

    // Button to go to the Registration Page
    public void BtnToRegister(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }
    // Button to go to Login page
    public void BtnLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }
}

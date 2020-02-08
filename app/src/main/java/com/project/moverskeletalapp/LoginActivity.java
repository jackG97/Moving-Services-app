package com.project.moverskeletalapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;


public class LoginActivity extends AppCompatActivity {


    /*private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\\\S+$)" +         //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");*/

    //Declaring Varaibles
    private EditText emailET;
    private EditText passwordET;
    private Button logBtn;
    private Button quickLogBtn;
    private Boolean validateEmail = false;
    private Boolean validatePassword = false;
    String enteredEmail;
    String enteredPassword;
    String email;
    String password;


    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseAuth.getInstance().signOut();
        progressDialog = new ProgressDialog(this);
        //Searching for ID of variables by the name of the Text box
        emailET = findViewById(R.id.EmailET);
        passwordET = findViewById(R.id.PasswordET);
        logBtn = findViewById(R.id.logBtn);
        //quickLogBtn = findViewById(R.id.quickLogBtn);

        firebaseAuth.signOut();

        //On click function for login button. checks the condition of validation mentioned below/
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmInput(v);
            }
        });
       /* quickLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuickLog(v);
            }
        });*/



    }


    //redirects user to Next page after successful login
    public void SecondActivity() {
        Intent intent = new Intent(this, UserChoiceActivity.class);
        startActivity(intent);
    }

    //checks the validation conditions for email.
    private boolean validateEmail() {
        email = emailET.getText().toString().trim();

        //checking if there are an blanks in the text boxes. if there is it will no redirect to the next page unless it is filled
        if (email.isEmpty()) {
            emailET.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailET.setError("Please enter a valid email address");
            return false;
        } else {
            emailET.setError(null);
            return true;
        }
    }

    //checks the validation conditions for password.
    private boolean validatePassword() {
        password = passwordET.getText().toString().trim();

        //checking if there no blanks in the text boxes and making sure the password is not less than 10 characters. conditions must be met to continue to next page
        if (password.isEmpty()) {
            passwordET.setError("fields can't be empty");
            return false;
        } else if (password.length() < 7){
            passwordET.setError("Invalid Password");
            return false;
        } else {
            passwordET.setError(null);
            return true;
        }
    }

    //method is used to check to see of both validation conditions for email and password are true or false. if conditions are met, user will be redirected to next page.
    public void confirmInput(View v) {
        if (validateEmail() && validatePassword()) {

            firebaseAuth.signInWithEmailAndPassword(email,password)
                    .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            progressDialog.setMessage("Signing in. Please Wait...");
                            progressDialog.show();
                            SecondActivity();
                        }
                    });


            //prints a small box below with email and password entered.
            /*String input = "email: " + emailET.getText().toString().trim();
            input += "\n";
            input += "password: " + passwordET.getText().toString().trim();

            //Toast method below is used to display the box.
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();*/
        }


    }
    /*public void QuickLog(View v) {

            firebaseAuth.signInWithEmailAndPassword("Test@test.test","Test1234")
                    .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            progressDialog.setMessage("Signing in. Please Wait...");
                            progressDialog.show();
                            SecondActivity();
                        }
                    });


            //prints a small box below with email and password entered.
            //String input = "email: " + emailET.getText().toString().trim();
            //input += "\n";
            //input += "password: " + passwordET.getText().toString().trim();

            //Toast method below is used to display the box.
            //Toast.makeText(this, input, Toast.LENGTH_SHORT).show();



    }*/




}

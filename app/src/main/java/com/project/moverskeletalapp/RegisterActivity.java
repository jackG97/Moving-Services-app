package com.project.moverskeletalapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    //Variables to hold the completed registrations intake.

    public String password = "";
    public String email = "";


    //temp variables used while validating.
    public String tempEmail;
    public String tempPass;

    //Boolean variables to check each validation for the inputs.

    boolean validPassword = false;
    boolean validEmail = false;

    //Code that creates an instance of the database
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    //Code generated on page load.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //code that sets a database under the name 'user login'
        //databaseReference = FirebaseDatabase.getInstance().getReference("user login");

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
    }

    //Button to finish Registration then go back to login page.
    public void btnFinishReg(View view) {

        //Code that takes the input values to be run through validation.
        EditText checkPassword = (EditText) findViewById(R.id.setPassword);
        tempPass = checkPassword.getText().toString();
        EditText checkEmail = (EditText) findViewById(R.id.setEmail);
        tempEmail = checkEmail.getText().toString();
        TextView DisplayedMessage = findViewById(R.id.outputError);

        //Assigns the required characters for the email validation.
        Pattern patternEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcherEmail = patternEmail.matcher(tempEmail);

        //Assigns the required characters for the password validation
        Pattern patternPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
        Matcher matcherPassword = patternPassword.matcher(tempPass);

        //Code to validate the password.
        if (matcherPassword.matches() == true) {
            validPassword = true;
        } else {
            validPassword = false;
            checkPassword.setError(checkPassword.getHint() + " is invalid");
        }

        //code to validate the email.
        if (matcherEmail.matches() == true) {
            validEmail = true;
        } else {
            validEmail = false;
            checkEmail.setError(checkEmail.getHint() + " is invalid");
        }

        //code to validate the username
        /*if (checkUsername.length() > 7) {
            validUsername = true;
        } else {
            validUsername = false;
            checkUsername.setError(checkUsername.getHint() + " is too short");
        }*/

        //code that checks all three inputs are valid
        if (validPassword == true && validEmail == true) {
            //DisplayedMessage.setText(String.valueOf("Registration Completed"));

            password = tempPass;
            email = tempEmail;

            firebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        //@Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                        }
                    });
            //String that has a random 'key' value for id

            //id = firebaseAuth.getCurrentUser().getUid();
            /*id = databaseReference.push().getKey();
            //Calls the User class and passes in the given values to the array.
            Users users = new Users(id,username,email,password);
            //saves the array to a database under the given 'child'
            databaseReference.child(id).setValue(users);
            */
            /*id = null;
            //id = firebaseAuth.getCurrentUser().getUid();
            //For adding into database
            //databaseReference = FirebaseDatabase.getInstance().getReference("Registration").child(id);
            databaseReference = FirebaseDatabase.getInstance().getReference("Registration").child("Ref");
            //databaseReference = databaseReference.child("Profile").child(id);

            databaseReference.child("Name").setValue(username);
            databaseReference.child("Email").setValue(email);*/
            progressDialog.setMessage("Registering Please Wait...");
            progressDialog.show();

            //code to add a 1.5 second delay before changing the view.
            try {
                //sleep 1.5 seconds
                Thread.sleep(1500);

                //code that brings the user back to the login screen.
                Intent returnToLoading = new Intent(this, LoginRegActivity.class);
                startActivity(returnToLoading);
            } catch (InterruptedException e) {
                e.printStackTrace();
                DisplayedMessage.setText(String.valueOf("Problem with sleeper catch"));
            }
        //Code that happens if the validation fails.
        } else {
            DisplayedMessage.setText(String.valueOf("Problem with Registration"));
        }

    }
}



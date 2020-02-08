package com.project.moverskeletalapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReviewActivity extends AppCompatActivity {

    //Declaring variables
    private RatingBar ratingBar;
    private String id;
    private String ratingBarDisplay;
    private String Comments;


    DatabaseReference databaseReference;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        //Searching for ID of variables by the name of the Text box
        final EditText Comments = (EditText) findViewById(R.id.CommentET);
        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        Button SubmitBtn = (Button) findViewById(R.id.SubmitBtn);
        final TextView ratingBarDisplay = (TextView) findViewById(R.id.DisplayET);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        id = firebaseAuth.getCurrentUser().getUid();

        //code for the submit button. When button is clicked review is saved from textbox and will display below thanks for rating us.
        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingBarDisplay.setText("your Rating is " + ratingBar.getRating());
                backpage();
            }
        });
    }


    //backpage function below is performed when submit button is clicked.
    public void backpage(){

        //code saves the used id and review to the database
        databaseReference = FirebaseDatabase.getInstance().getReference("RatingsBase").child(id);

        databaseReference.child("UID").setValue(id);

        //databaseReference.child("Test").setValue("Hi");
        //databaseReference.child("Ratings").setValue(ratingBarDisplay);
        databaseReference.child("comments").setValue(Comments);


        progressDialog.setMessage("Thanks for you rating us");
        progressDialog.show();

        //redirects user to the next page
        Intent intent = new Intent (this, MoverDisplayedDetails.class);
        startActivity(intent);
    }

    }



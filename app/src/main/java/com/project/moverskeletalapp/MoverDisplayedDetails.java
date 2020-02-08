package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class MoverDisplayedDetails extends AppCompatActivity {

    private String CurrentUserID;
    private String TargetUserID;
    private String targetUserName;
    private String targetCarReg;
    private String targetLicenceid;
    private String targetMovPN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mover_displayed_details);

        DatabaseReference databaseReference;
        FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();

        CurrentUserID = firebaseAuth.getCurrentUser().getUid();

        targetUserName="Placeholder";
        targetCarReg="Placeholder";
        targetLicenceid="Placeholder";
        targetMovPN="Placeholder";


        TextView showMoverName = findViewById(R.id.showMoverName);
        showMoverName.setText(String.valueOf(targetUserName));
        TextView showVecReg = findViewById(R.id.showVecReg);
        showVecReg.setText(String.valueOf(targetCarReg));
        TextView showLicNo = findViewById(R.id.showLicNo);
        showLicNo.setText(String.valueOf(targetLicenceid));
        TextView showMovPN = findViewById(R.id.showMovPN);
        showMovPN.setText(String.valueOf(targetMovPN));



    }
    /*
    // Button to go to Contact page
    public void btnContactMover(View view){
        Intent intent = new Intent(this, ChatCustomerSideActivity.class);
        startActivity(intent);

    }*/

    // Button to go to Map page
    public void btnMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);

    }

    // Button to go to Review page
    public void btnReview(View view){
        Intent intent = new Intent(this, ReviewActivity.class);
        startActivity(intent);

    }
}

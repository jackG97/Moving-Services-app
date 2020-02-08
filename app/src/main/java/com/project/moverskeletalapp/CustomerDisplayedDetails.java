package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class CustomerDisplayedDetails extends AppCompatActivity {

    private String CurrentUserID;
    private String TargetUserID;
    private String targetUserName;
    private String targetUserArea;
    private String targetUserPrice;
    private String targetUserPN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_displayed_details);

        DatabaseReference databaseReference;
        FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();

        CurrentUserID = firebaseAuth.getCurrentUser().getUid();

        targetUserName="Placeholder";
        targetUserArea="Placeholder";
        targetUserPrice="Placeholder";
        targetUserPN="Placeholder";

        TextView showCustName = findViewById(R.id.showCustName);
        showCustName.setText(String.valueOf(targetUserName));
        TextView showCustArea = findViewById(R.id.showCustArea);
        showCustArea.setText(String.valueOf(targetUserArea));
        TextView showCustPrice = findViewById(R.id.showCustPrice);
        showCustPrice.setText(String.valueOf("€"+targetUserPrice));
        TextView showCustPN = findViewById(R.id.showCustPN);
        showCustPN.setText(String.valueOf(targetUserPN));
    }

    public void btnMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);

    }

    public void btnContactCustomer(View view){
        Intent intent = new Intent(this, ChatMoverSideActivity.class);
        startActivity(intent);

    }
}

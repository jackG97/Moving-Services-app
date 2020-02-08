package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MoverListOfMatches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mover_list_of_matches);
    }
    //On Click command to bring up matches details
    public void btnMoverMatch(View view){
        Intent intent = new Intent(this, CustomerDisplayedDetails.class);
        startActivity(intent);

    }
}


/*
package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MoverListOfMatches extends AppCompatActivity {

    //creating my ET variables
    //private boolean validateAddress;
    private static final String TAG = "ViewDatabase";
    private ListView cListView;


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mover_list_of_matches);

        //connecting my variables to the ETs in GUI

        //taking snapshot of database to grab data
        myRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
    }
    //attaching data pulled from DB to empty variables in GUI
    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){

            CustomerSetDetailsActivity cInfo = new CustomerSetDetailsActivity();

            cInfo.setUserName(ds.child(userID).getValue(CustomerSetDetailsActivity.class).getUserName()); //set & get the name
            cInfo.setPhoneNumber(ds.child(userID).getValue(CustomerSetDetailsActivity.class).getPhoneNumber()); //set & get the name
            cInfo.setHomeAddress(ds.child(userID).getValue(CustomerSetDetailsActivity.class).getHomeAddress()); //set & get the address
            cInfo.setAmount(ds.child(userID).getValue(CustomerSetDetailsActivity.class).getAmount());
            Log.d(TAG, "showData: Name: " + cInfo.getUserName());
            Log.d(TAG, "showData: Number: " + cInfo.getPhoneNumber());
            Log.d(TAG, "showData: Address: " + cInfo.getHomeAddress());
            Log.d(TAG, "showData: Price Offered For Move: " + cInfo.getAmount());


            ArrayList<String> array = new ArrayList<>();
            array.add(cInfo.getUserName());
            array.add(cInfo.getPhoneNumber());
            array.add(cInfo.getHomeAddress());
            array.add(cInfo.getAmount());
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
            cListView.setAdapter(adapter);


        }
    }


    //On Click command to bring up matches details
    public void btnMoverMatch(View view){
        Intent intent = new Intent(this, CustomerDisplayedDetails.class);
        startActivity(intent);

    }
}
*/


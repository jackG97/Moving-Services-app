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
*//*



package com.project.moverskeletalapp;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
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


public class CustomersListOfMatchsActivity extends AppCompatActivity {

    private ListView mListView;


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    private String userID;

    private static final String TAG = "ViewDatabase";


    //connecting my variables to the EditTexts in the GUI
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_list_of_matchs);
        mListView = findViewById(R.id.custResultsList);


        */
/*
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();
        *//*



        myRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });

    }


/*    //Taking a screenshot of the database to pull data
    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            MoverSetDetailsActivity mInfo = new MoverSetDetailsActivity();


            mInfo.setUserName(ds.child(userID).getValue(MoverSetDetailsActivity.class).getUserName()); //set & get the name
            mInfo.setPhoneNumber(ds.child(userID).getValue(MoverSetDetailsActivity.class).getPhoneNumber()); //set & get the name
            mInfo.setCarReg(ds.child(userID).getValue(MoverSetDetailsActivity.class).getCarReg()); //set & get veh reg


            //display all the information
            Log.d(TAG, "showData: Name: " + MoverSetDetailsActivity.getUserName());
            Log.d(TAG, "showData: Phone Number: " + MoverSetDetailsActivity.getPhoneNumber());
            Log.d(TAG, "showData: Car Registration: " + MoverSetDetailsActivity.getCarReg());


            ArrayList<String> array = new ArrayList<>();
            array.add(mInfo.getUserName());
            array.add(mInfo.getPhoneNumber());
            array.add(mInfo.getCarReg());

            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
            mListView.setAdapter(adapter);

        }
    }

    //On Click command to bring up matches details
    public void btnCustomerMatch(View view){
        Intent intent = new Intent(this, MoverDisplayedDetails.class);
        startActivity(intent);

    }
}

/*

*/

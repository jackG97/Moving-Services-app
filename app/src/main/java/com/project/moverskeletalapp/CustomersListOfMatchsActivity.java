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

public class CustomersListOfMatchsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_list_of_matchs);
    }

    //On Click command to bring up matches details
    public void btnCustomerMatch(View view){
        Intent intent = new Intent(this, MoverDisplayedDetails.class);
        startActivity(intent);


    }
}
/*
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

*/


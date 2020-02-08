package com.project.moverskeletalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class UserChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);
        String id;
        DatabaseReference databaseReference;
        FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();

        id = firebaseAuth.getCurrentUser().getUid();
        TextView DisplayedMessage = findViewById(R.id.textView4);

        //DisplayedMessage.setText(String.valueOf("User ID Test "+id));
    }
    //Button that sets the user as a Customer and brings them to that details page
    public void btnChoiceCust(View view){
        Intent intent = new Intent(this, CustomerSetDetailsActivity.class);
        startActivity(intent);

    }
    //Button that sets the user as a Mover and brings them to that details page
    public void btnChoiceMover(View view){
        Intent intent = new Intent(this, MoverSetDetailsActivity.class);
        startActivity(intent);

    }
}

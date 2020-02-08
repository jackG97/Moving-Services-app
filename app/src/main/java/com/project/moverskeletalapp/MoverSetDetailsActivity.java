package com.project.moverskeletalapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MoverSetDetailsActivity extends AppCompatActivity {

    private EditText fname;
    private EditText lname;
    private EditText phone;
    private EditText VehReg;
    private EditText License;
    private Button Save2;
    private String id;
    private String userType = "Mover";
    private String firstname;
    private String phonenumber;
    private String CarReg;
    private String moveid;


    DatabaseReference databaseReference;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mover_set_details);

        fname = findViewById(R.id.setMoverUsername);
        //lname = findViewById(R.id.LnameET);
        phone = findViewById(R.id.PhoneET);
        VehReg = findViewById(R.id.CarET);
        License = findViewById(R.id.IdET);
        Save2 = findViewById(R.id.SaveBtn);



        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        id = firebaseAuth.getCurrentUser().getUid();
    }
    //Saves the details entered for the mover
    public void MoverSetDetails(View view){

        if (validatefname() && validatephone() && validateCar() && validateID()){



            databaseReference = FirebaseDatabase.getInstance().getReference("MoverUserBase").child(id);
            //databaseReference = databaseReference.child("Profile").child(id);

            databaseReference.child("UID").setValue(id);
            databaseReference.child("UserType").setValue(userType);
            databaseReference.child("Username").setValue(firstname);
            databaseReference.child("Phone").setValue(phonenumber);
            databaseReference.child("VehReg").setValue(CarReg);
            databaseReference.child("License").setValue(moveid);


            progressDialog.setMessage("Saving. Please Wait...");
            progressDialog.show();





            String input = " Your Details have been saved";

            //Toast methos prints out the above string in a little box
            Toast.makeText(this, input, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MoverListOfMatches.class);
            startActivity(intent);
        }




    }


    //boolean statement is used for checking to see if the first name box is or is not empty
    private boolean validatefname(){
        firstname = fname.getText().toString().trim();

        if(firstname.isEmpty()){
            fname.setError("Fields can't be empty");
            return false;
        } else {
            fname.setError(null);
            return true;
        }
    }

    //boolean statement is used for checking to see if the last name box is or is not empty
    /*private boolean validatelname(){
        String lastname = lname.getText().toString().trim();

        if(lastname.isEmpty()){
            lname.setError("Fields can't be empty");
            return false;
        } else {
            lname.setError(null);
            return true;
        }
    }*/

    //boolean statement is used for checking to see if the phone number box is or is not empty and to see of the phone number valid. it must contain 10 digits or its not clarified as a real number
    private boolean validatephone() {
        phonenumber = phone.getText().toString().trim();

        if(phonenumber.isEmpty()) {
            phone.setError("Fields cant be empty");
            return false;
        } else {
            phone.setError(null);
            return true;
        }
    }

    //boolean statement is used for checking to see if the address box is or is not empty
    private boolean validateCar(){
        CarReg = VehReg.getText().toString().trim();

        if(CarReg.isEmpty()){
            VehReg.setError("Fields can't be empty");
            return false;
        } else {
            VehReg.setError(null);
            return true;
        }
    }

    //boolean statement is used for checking to see if the price box is or is not empty
    private boolean validateID(){
        moveid = License.getText().toString().trim();

        if(moveid.isEmpty()){
            License.setError("Fields can't be empty");
            return false;
        } else {
            License.setError(null);
            return true;
        }
    }


    //the validate method below checks to see if all the boolean statements above are true or false. if the boolean statements are true then it will select the User choice method. this calls upon the redirect activity at the top of the page which will redirect the user to the next page.
    public void Confirm(View v){



    }

}

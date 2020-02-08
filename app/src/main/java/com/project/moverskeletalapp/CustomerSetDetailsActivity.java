package com.project.moverskeletalapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerSetDetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //Declaring Variables
    private EditText fname;
    private EditText lname;
    private EditText phone;
    private EditText address;
    private EditText price;
    private Spinner type;
    private Button save;
    private String id;
    private String userType = "Customer";
    private String firstname;
    private String phonenumber;
    private String homeaddress;
    private String amount;


    DatabaseReference databaseReference;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_set_details);

        //Searching for ID of variables by the name of the Text box
        fname = findViewById(R.id.setCustUsername);
        //lname = findViewById(R.id.LnameET);
        phone = findViewById(R.id.PhoneET);
        address = findViewById(R.id.AddressET);
        price = findViewById(R.id.PriceET);
        //type = findViewById(R.id.spinner1);
        save = findViewById(R.id.saveBtn);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        //On click function for save details button. It calls upon the validate method which checks all the text boxes.
        id = firebaseAuth.getCurrentUser().getUid();

        //Spinner is the used to make a drop menu selection.
        //Spinner spinner = findViewById(R.id.spinner1);
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Type, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //spinner.setAdapter(adapter);
       // spinner.setOnItemSelectedListener(this);


    }
    public void btnCustomerSaveDetails(View view) {

        if (validatefname() && validatephone() && validateaddress() && validateprice()){









            //id = firebaseAuth.getCurrentUser().getUid();
            //For adding into database
            //databaseReference = FirebaseDatabase.getInstance().getReference("Registration").child(id);
            databaseReference = FirebaseDatabase.getInstance().getReference("CustomerUserBase").child(id);
            //databaseReference = databaseReference.child("Profile").child(id);

            databaseReference.child("UID").setValue(id);
            databaseReference.child("userType").setValue(userType);
            databaseReference.child("Username").setValue(firstname);
            databaseReference.child("Phone").setValue(phonenumber);
            databaseReference.child("Address").setValue(homeaddress);
            databaseReference.child("Price").setValue(amount);
            //databaseReference.child("SpinnerType").setValue(type);
            //String input = " Your Details have been saved";
            progressDialog.setMessage("Saving. Please Wait...");
            progressDialog.show();

            UserChoice();

        }




    }

    // Saves the details to the server
    public void UserChoice(){
        Intent intent = new Intent(this, CustomersListOfMatchsActivity.class);
        startActivity(intent);
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
        } else if (phone.length()<10) {
            phone.setError("Not a valid phone Number");
            return false;
        } else {
            phone.setError(null);
            return true;
        }
    }

    //boolean statement is used for checking to see if the address box is or is not empty
    private boolean validateaddress(){
        homeaddress = address.getText().toString().trim();

        if(homeaddress.isEmpty()){
            address.setError("Fields can't be empty");
            return false;
        } else {
            address.setError(null);
            return true;
        }
    }

    //boolean statement is used for checking to see if the price box is or is not empty
    private boolean validateprice(){
        amount = price.getText().toString().trim();

        if(amount.isEmpty()){
            price.setError("Fields can't be empty");
            return false;
        } else {
            price.setError(null);
            return true;
        }
    }


    //the validate method below checks to see if all the boolean statements above are true or false. if the boolean statements are true then it will select the User choice method. this calls upon the redirect activity at the top of the page which will redirect the user to the next page.
    public void validate(View v){



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

package com.example.project.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.Activity.SignInActivity;
import com.example.project.ModelClass;
import com.example.project.R;
import com.example.project.baseclass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button signup2btn;
    ModelClass modelClass;
    EditText name, email,  password, confirmpassword, phone, alternativephone;
    Spinner spinner;
    String[] gender= new String[]{"Select", "Female", "Male"};

    String sname, semail, sgender, spassword, sconfirmpassword, sphoneno, salternativeno;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    boolean isAllFieldChecked = false;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        spinner = (Spinner) findViewById(R.id.gender);
        password = (EditText) findViewById(R.id.password2);
        confirmpassword = (EditText) findViewById(R.id.confirmpassword);
        phone = (EditText) findViewById(R.id.phoneno);

        alternativephone = (EditText) findViewById(R.id.alternativeno);
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dietplan-d8c38-default-rtdb.firebaseio.com/");


        spinner.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,gender);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);


        signup2btn = (Button) findViewById(R.id.signup2);
        signup2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sname = name.getText().toString();
                semail = email.getText().toString();
                sgender = spinner.getSelectedItem().toString();
                spassword = password.getText().toString();
                sconfirmpassword = confirmpassword.getText().toString();
                sphoneno = phone.getText().toString();
                salternativeno = alternativephone.getText().toString();

                isAllFieldChecked = CheckAllFields();
                if (isAllFieldChecked == true) {
                    if (sname.isEmpty() || semail.isEmpty() || sphoneno.isEmpty() || spassword.isEmpty() ||
                            sconfirmpassword.isEmpty() || sphoneno.isEmpty() || salternativeno.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter All Details", Toast.LENGTH_SHORT).show();
                    }
                    if (spassword.equals(sconfirmpassword)) {
                        databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.hasChild(sphoneno)) {
                                    Toast.makeText(getApplicationContext(), "Phone is already registered", Toast.LENGTH_SHORT).show();
                                } else {
                                    databaseReference.child("Profile").child(sphoneno).child("Name").setValue(sname);
                                    databaseReference.child("Profile").child(sphoneno).child("Email").setValue(semail);
                                    databaseReference.child("Profile").child(sphoneno).child("Gender").setValue(sgender);
                                    databaseReference.child("Profile").child(sphoneno).child("Password").setValue(spassword);
                                    databaseReference.child("Profile").child(sphoneno).child("Phone").setValue(sphoneno);
                                    databaseReference.child("Profile").child(sphoneno).child("Alternatephone").setValue(salternativeno);
                                    Toast.makeText(getApplicationContext(), "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(getApplicationContext(), "error" + error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    } else {
                        Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }

    private boolean CheckAllFields() {
        if (sname.length() == 0) {
            name.setError("This field is required");
            Toast.makeText(getApplicationContext(), "Name is required", Toast.LENGTH_LONG).show();
            return false;
        }

        if (semail.length()==0){
            email.setError("This field is required");
            Toast.makeText(getApplicationContext(), "Email is required", Toast.LENGTH_LONG).show();
            return false;
        }else if (!semail.matches(emailPattern)){
            email.setError("Enter valid email");
            Toast.makeText(getApplicationContext(), "Enter valid email", Toast.LENGTH_LONG).show();
        }

        if(spassword.length()==0){
            password.setError("This field is required");
            Toast.makeText(getApplicationContext(), "Password is required", Toast.LENGTH_LONG).show();
            return false;
        }else if(spassword.length()<8){
            password.setError("Password must be minimum 8 characters");
            Toast.makeText(getApplicationContext(), "Password must be minimum 8 characters", Toast.LENGTH_LONG).show();
            return false;
        }

        if(sconfirmpassword.length()==0){
            confirmpassword.setError("This field is required");
            Toast.makeText(getApplicationContext(), "This field is required", Toast.LENGTH_LONG).show();
            return false;
        }else if (!spassword.equals(sconfirmpassword)){
            confirmpassword.setError("Password is not matching");
            Toast.makeText(getApplicationContext(), "Password is not matching", Toast.LENGTH_LONG).show();
            return false;
        }


        if(sphoneno.length()==0){
            phone.setError("This field is required");
            Toast.makeText(getApplicationContext(), "This field is required", Toast.LENGTH_LONG).show();
            return false;
        }else if(sphoneno.length()!=10){
            phone.setError("Enter valid mobile number");

            return false;
        }

        if(salternativeno.length()==0){
            alternativephone.setError("This field is required");
            return false;
        }else if(salternativeno.length()!=10){
            alternativephone.setError("Enter valid mobile number");
            Toast.makeText(getApplicationContext(), "Enter valid phone number", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(getApplicationContext(),gender[i] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

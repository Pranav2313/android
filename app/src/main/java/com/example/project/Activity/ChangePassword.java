package com.example.project.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChangePassword extends AppCompatActivity {
EditText newPwd,changePwd;
Button change;
String phoneNumber;
String newPwdStr,changePwdStr;
    DatabaseReference databaseReference;
    boolean isAllFieldChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        newPwd=findViewById(R.id.edt_new_pass);
        changePwd=findViewById(R.id.edt_confirm_pass);
        change=findViewById(R.id.btn_submit_pass);
        Bundle bundle = getIntent().getExtras();
        phoneNumber=bundle.getString("mobile");
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dietplan-d8c38-default-rtdb.firebaseio.com/");

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               newPwdStr=newPwd.getText().toString();
                changePwdStr=changePwd.getText().toString();
                isAllFieldChecked = CheckAllFields();
                if (isAllFieldChecked == true) {
                    if (newPwdStr.isEmpty() || changePwdStr.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please Enter All Details", Toast.LENGTH_SHORT).show();
                    }
                    if (newPwdStr.equals(changePwdStr)) {
                        databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                databaseReference.child("Profile").child(phoneNumber).child("Password").setValue(newPwdStr);
                                Toast.makeText(ChangePassword.this, "Password changed successfully", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(ChangePassword.this, SignInActivity.class);
                                startActivity(i);

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                }
            }
        });


    }

    private boolean CheckAllFields(){

        if(newPwdStr.length()==0){
            newPwd.setError("This field is required");
            Toast.makeText(getApplicationContext(), "Password is required", Toast.LENGTH_LONG).show();
            return false;
        }else if(newPwdStr.length()<8){
            newPwd.setError("Password must be minimum 8 characters");
            Toast.makeText(getApplicationContext(), "Password must be minimum 8 characters", Toast.LENGTH_LONG).show();
            return false;
        }

        if(changePwdStr.length()==0){
            changePwd.setError("This field is required");
            Toast.makeText(getApplicationContext(), "This field is required", Toast.LENGTH_LONG).show();
            return false;
        }else if (!newPwdStr.equals(changePwdStr)){
            changePwd.setError("Password is not matching");
            Toast.makeText(getApplicationContext(), "Password is not matching", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(ChangePassword.this,SignInActivity.class);
        startActivity(i);
    }
}
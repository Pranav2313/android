package com.example.project.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.project.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class ForgetPasswordActivity extends AppCompatActivity {

    Button btnsend;
    EditText phn;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        getSupportActionBar().hide();

        ProgressBar progressbar = findViewById(R.id.progressbar_sending_otp);
        phn=findViewById(R.id.femail);
        btnsend=(Button)findViewById(R.id.send);
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dietplan-d8c38-default-rtdb.firebaseio.com/");

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phnstr=phn.getText().toString();
                databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChild(phnstr)) {

                if (!phn.getText().toString().trim().isEmpty()) {
                    if ((phn.getText().toString().trim()).length() == 10) {

                        progressbar.setVisibility(View.VISIBLE);
                        btnsend.setVisibility(View.INVISIBLE);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber("+91" + phn.getText().toString(), 60,
                                TimeUnit.SECONDS, ForgetPasswordActivity.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        progressbar.setVisibility(View.GONE);
                                        btnsend.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressbar.setVisibility(View.GONE);
                                        btnsend.setVisibility(View.VISIBLE);
                                        Toast.makeText(ForgetPasswordActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressbar.setVisibility(View.GONE);
                                        btnsend.setVisibility(View.VISIBLE);
                                        Intent i = new Intent(getApplicationContext(), OptActivity.class);
                                        i.putExtra("mobile", phnstr);
                                        i.putExtra("backendotp", backendotp);
                                        startActivity(i);
                                    }
                                });
                    } else {
                        Toast.makeText(getApplicationContext(), "Please enter corrcet mobile number", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Please enter corrcet mobile number", Toast.LENGTH_SHORT).show();
                }}
                        else {
                            Toast.makeText(getApplicationContext(), "Mobile number not registered", Toast.LENGTH_SHORT).show();

                        }
         /*       Intent intent=new Intent(getApplicationContext(), OptActivity.class);
                intent.putExtra("NO",phnstr);
                startActivity(intent);*/
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}

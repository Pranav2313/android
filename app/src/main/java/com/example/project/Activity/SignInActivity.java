package com.example.project.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.ModelClass2;
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

public class SignInActivity extends AppCompatActivity {
    Button signinbutton1;
    EditText edusername,edpassword;
    String password2,name2,phone2,gender2;
    ModelClass2 modelClass2;
    TextView textView2;

    boolean isAllFieldChecked = false;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().hide();

        edusername=(EditText)findViewById(R.id.username);
        edpassword=(EditText)findViewById(R.id.password);

        textView2=(TextView) findViewById(R.id.signup);
        signinbutton1=(Button)findViewById(R.id.signin);

        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dietplan-d8c38-default-rtdb.firebaseio.com/");


        signinbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone2 = edusername.getText().toString();
                password2 = edpassword.getText().toString();
                isAllFieldChecked = CheckAllFields();
                if (isAllFieldChecked == true){
                    if (phone2.isEmpty() || phone2.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Enter All Details", Toast.LENGTH_SHORT).show();
                    } else {
                        databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.hasChild(phone2)) {

                                    final String getPassword = snapshot.child(phone2).child("Password").getValue(String.class);
                                    if (getPassword.equals(password2)) {
                                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                                        i.putExtra("Key", phone2);
                                        startActivity(i);
                                        Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }


              /*  Intent in =getIntent();
                name2=in.getStringExtra("name1");
//                email2=in.getStringExtra("email1");
                phone2=in.getStringExtra("phone1");
                gender2=in.getStringExtra("gender1");

//                Intent intent=getIntent();
//                String v1=intent.getStringExtra("signemail");
//                String v2=intent.getStringExtra("signpassword");
//
//                if(email==v1 && password==v2)
//                {
//                    getDataValue();
//                }

                if (!email2.isEmpty() && !password2.isEmpty())
                    getDataValue();
                else {
                    edusername.setError("Incorrect username");
                    edpassword.setError("Incorrect password");
                }*/
            }
            }
        });

    }
    private boolean CheckAllFields() {




        if(password2.length()==0){
           edpassword.setError("This field is required");
            Toast.makeText(getApplicationContext(), "Password is required", Toast.LENGTH_LONG).show();
            return false;
        }else if(password2.length()<8){
            edpassword.setError("Password must be minimum 8 characters");
            Toast.makeText(getApplicationContext(), "Password must be minimum 8 characters", Toast.LENGTH_LONG).show();
            return false;
        }



        if(phone2.length()==0){
           edusername.setError("This field is required");
            Toast.makeText(getApplicationContext(), "This field is required", Toast.LENGTH_LONG).show();
            return false;
        }else if(phone2.length()!=10){
            edusername.setError("Enter valid mobile number");

            return false;
        }


        return true;
    }

    public void signin(View view) {
        Intent intent=new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }

    public void Forget(View view) {
        Intent intent=new Intent(getApplicationContext(), ForgetPasswordActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

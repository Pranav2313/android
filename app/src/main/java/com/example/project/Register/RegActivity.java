package com.example.project.Register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.Activity.HomeActivity;
import com.example.project.R;

//public class RegActivity extends AppCompatActivity implements IRegisterCallback {
//
//    private IRegisterCall iRegisterCall;
//
//    EditText rg_name, rg_email, rg_mob, rg_pass, rg_repass;
//
//    Button btn_reg;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//
//        rg_name = findViewById(R.id.rg_name);
//        rg_email = findViewById(R.id.rg_email);
//        rg_mob = findViewById(R.id.rg_mob);
//        rg_pass = findViewById(R.id.rg_pass);
//        rg_repass = findViewById(R.id.rg_repass);
//
//        iRegisterCall = new RegController(getApplicationContext(),this);
//
//        btn_reg = findViewById(R.id.btn_reg);
//        btn_reg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String name = rg_name.getText().toString();
//                String email = rg_email.getText().toString();
//                String mobile = rg_mob.getText().toString();
//                String password = rg_pass.getText().toString();
//                String repassword = rg_repass.getText().toString();
//
//                if (password.equals(password)) {
//                    iRegisterCall.getRegisterData(name, email, mobile, password);
//                    Log.d("register","Name : " + name + ", Email : " + email + ", Mobile : " + mobile +
//                            ", Password : " + password + ", Re-enter Password : " + repassword);
//                }
//                else {
//                    Toast.makeText(RegActivity.this, "Passwords do not match..", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//    }
//
////    @Override
////    public void getResponse2(String name, String email, String mobile, String password) {
////
////
////    }
//
//    @Override
//    public void getResponse2(String message, int id, String name, String email, String phone, String password) {
//        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//        intent.putExtra("name", name);
//        intent.putExtra("email", email);
//        intent.putExtra("mobile",mobile);
//        intent.putExtra("password", password);
//        startActivity(intent);
//    }
//}
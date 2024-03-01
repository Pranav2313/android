package com.example.project;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Change_Password_Activity extends AppCompatActivity {

    EditText new_pass,confirm_pass;
    Button submit_pass;
    String newpass,confirmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        new_pass=findViewById(R.id.edt_new_pass);
        confirm_pass=findViewById(R.id.edt_confirm_pass);
        submit_pass=findViewById(R.id.btn_submit_pass);




        submit_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newpass=new_pass.getText().toString();
                confirmpass=confirm_pass.getText().toString();

                getpassword();
            }
        });
    }


    private void getpassword() {
        baseclass.getClient().passwordresponse(newpass,confirmpass).enqueue(new Callback<Change_Pass_Response>() {
            @Override
            public void onResponse(Call<Change_Pass_Response> call, Response<Change_Pass_Response> response) {
                if (response.isSuccessful()){

                    Toast.makeText(getApplicationContext(), "Password Successfully Updated", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Change_Pass_Response> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Password not Updated", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
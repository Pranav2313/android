package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project.Activity.HomeActivity;

public class Success extends AppCompatActivity {
Button done1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success2);

        done1=findViewById(R.id.done1);
        Bundle extras= getIntent().getExtras();
        String key=extras.getString("Key");
        done1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Success.this,HomeActivity.class);
                i.putExtra("Key",key);
                startActivity(i);

            }
        });
    }
}
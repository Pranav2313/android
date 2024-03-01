package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.project.R;

public class OrderPlaced extends AppCompatActivity  {
Button done;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);
        done=findViewById(R.id.done);
        Bundle extras=getIntent().getExtras();
        String key=extras.getString("Key").toString();
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OrderPlaced.this, HomeActivity.class);
                i.putExtra("Key",key);
                startActivity(i);
            }
        });
    }




}
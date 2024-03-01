package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project.R;

public class LanguageActivity extends AppCompatActivity {
    Button buttoneng,buttonara;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        getSupportActionBar().hide();

        button=(Button)findViewById(R.id.button);

        buttoneng=(Button)findViewById(R.id.englishbtn);
        buttonara=(Button)findViewById(R.id.arabicbtn);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getApplicationContext(),CalenderActivity.class);
//                startActivity(intent);
//            }
//        });

        buttoneng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                buttoneng.setBackgroundResource(R.drawable.languagebtnselect);
                buttoneng.setTextColor(getResources().getColor(R.color.colorWhite));
            }
        });
        buttonara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
               buttonara.setTextColor(getResources().getColor(R.color.colorWhite));
               buttonara.setBackgroundResource(R.drawable.languagebtnselect);
            }
        });

    }
}

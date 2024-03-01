package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThankyouActivity extends AppCompatActivity {

    Button selectmeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

        selectmeal=findViewById(R.id.btn_selectmeal);

        selectmeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fr=new CalendarFragment();
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.nav_host_fragment,fr);
                transaction.commit();
            }
        });
    }
}
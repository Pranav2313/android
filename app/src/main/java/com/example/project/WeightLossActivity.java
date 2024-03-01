package com.example.project;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.Activity.OrderPlaced;
import com.example.project.Fragment.CheckoutFragment;
import com.example.project.Fragment.DislikeFragment;
import com.example.project.models.Home.HomeResponse;
import com.example.project.models.MealPlanInfo.Data;
import com.example.project.models.MealPlanInfo.DurationsItem;
import com.example.project.models.MealPlanInfo.MealPlanInfoResponse;
import com.example.project.models.MealPlanInfo.ProteinsItem;
import com.example.project.network.RestServiceBuilder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WeightLossActivity extends AppCompatActivity {
    //add data to setViews
    int mInteger = 0,a,b,c;
    int mInteger1 = 0;
    Button  startDate,endDate,Proceedtopay,increasebtn1, increasebtn2, decreasebtn1, decreasebtn2, proceedtopay, dislikebtn, duration1, duration2, duration3, duration4, amount;
    int meal_id;
    RadioGroup duration;
    RadioButton radioButton;
    String durationStr;
    TextView meal_name, name, proteins_price, carbs_price, proteins, carbs;
    ImageView meal_image;
    ProgressDialog progressDialog;
    List<DurationsItem> durationsItemList;
    List<ProteinsItem> proteinsItemList;
    DatabaseReference databaseReference;
    DatePicker datePicker;
    String firstday,lastday;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_weight_loss);
        // Inflate the layout for this fragment
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setCancelable(false);

        increasebtn1 = findViewById(R.id.proincrease);
        increasebtn2 = findViewById(R.id.carincrease);
        decreasebtn1 = findViewById(R.id.prodecrease);
        decreasebtn2 = findViewById(R.id.cardecrease);
        proceedtopay = findViewById(R.id.proceedtopaybtn);
        datePicker=new DatePicker(getApplicationContext());
        meal_name = findViewById(R.id.meal_name);
        meal_image = findViewById(R.id.meal_image);

        proteins_price = findViewById(R.id.proteins_price);
        carbs_price = findViewById(R.id.carbs_price);
        proteins = findViewById(R.id.protext2);
        carbs = findViewById(R.id.cartext2);
        amount = findViewById(R.id.amount);
        proceedtopay=findViewById(R.id.proceedtopaybtn);
        startDate=findViewById(R.id.startdate1);
        endDate=findViewById(R.id.enddate1);
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dietplan-d8c38-default-rtdb.firebaseio.com/");
        Bundle extras=getIntent().getExtras();
        String key=extras.getString("Key");

        Toast.makeText(this, key, Toast.LENGTH_SHORT).show();
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(WeightLossActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                StringBuilder builder=new StringBuilder();;
                                builder.append((datePicker.getMonth() + 1)+"/");//month is 0 based
                                builder.append(datePicker.getDayOfMonth()+"/");
                                builder.append(datePicker.getYear());
                                firstday=builder.toString();

                                a=datePicker.getMonth() + 1;
                                b =datePicker.getDayOfMonth();
                                c= datePicker.getYear();
                            }

                        }, c, a, b);
                datePickerDialog.show();
            }
        });
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(WeightLossActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                StringBuilder builder=new StringBuilder();;
                                builder.append((datePicker.getMonth() + 1)+"/");//month is 0 based
                                builder.append(datePicker.getDayOfMonth()+"/");
                                builder.append(datePicker.getYear());
                                lastday=builder.toString();

                                a=datePicker.getMonth() + 1;
                                b =datePicker.getDayOfMonth();
                                c= datePicker.getYear();
                            }
                        }, a, b, c);
                datePickerDialog.show();
            }
        });
        proceedtopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String proteinStr=proteins.getText().toString();
                String carbsStr=carbs.getText().toString();
                databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                       databaseReference.child("Profile").child(key).child("Order1").child("Plan").setValue(durationStr+"Weight Loss");
                        databaseReference.child("Profile").child(key).child("Order1").child("Start").setValue(firstday);
                        databaseReference.child("Profile").child(key).child("Order1").child("Last").setValue(lastday);
                        databaseReference.child("Profile").child(key).child("Order1").child("Protein").setValue(proteinStr);
                        databaseReference.child("Profile").child(key).child("Order1").child("Carbohydrates").setValue(carbsStr);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                Intent i=new Intent(getApplicationContext(), OrderPlaced.class);
                i.putExtra("Key",key);
                startActivity(i);
            }
        });

        proteinsItemList = new ArrayList<ProteinsItem>();
        durationsItemList = new ArrayList<DurationsItem>();

        name = findViewById(R.id.name);
        // showProgress(true);
        meal_id = getIntent().getIntExtra("key", 0);
        // getData();



        increasebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseInteger1();
            }
        });

        increasebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseInteger2();
            }
        });

        decreasebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseInteger1();
            }
        });

        decreasebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseInteger2();
            }
        });


    }

    private void decreaseInteger1() {
        mInteger = mInteger - 50;
        display(mInteger);
    }

    private void display(int mInteger) {
        TextView protext = (TextView) findViewById(R.id.protext2);
        protext.setText("" + mInteger);
    }

    private void decreaseInteger2() {
        mInteger1 = mInteger1 - 50;
        display1(mInteger1);
    }

    private void display1(int mInteger1) {
        TextView cartext = (TextView) findViewById(R.id.cartext2 );
        cartext.setText("" + mInteger1);
    }

    private void increaseInteger2() {
        mInteger1 = mInteger1 + 50;
        display1(mInteger1);
    }

    private void increaseInteger1() {
        mInteger = mInteger + 50;
        display(mInteger);
    }





    }





package com.example.project.Fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.Activity.HomeActivity;
import com.example.project.Activity.OrderPlaced;
import com.example.project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SelectAddress extends AppCompatActivity {
Button bt;
TextView appartment1,area1,avenue1,block1,building1,floor1,street1;
TextView appartment2,area2,avenue2,block2,building2,floor2,street2;
TextView appartment3,area3,avenue3,block3,building3,floor3,street3;
CheckBox place1,place2,place3;

 String Appartment1;
 String Appartment2;
 String Appartment3;
 String Area1;
 String Area2;
 String Area3;
 String Avenue1;
 String Avenue2;
 String Avenue3;
 String Block1;
 String Block2;
 String Block3;
 String Building1;
 String Building2;
 String Building3;
 String Floor1;
 String Floor2;
 String Floor3;
 String Street1;
 String Street2;
 String Street3;

    DatabaseReference databaseReference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_address);
        bt=findViewById(R.id.click);
        appartment1=findViewById(R.id.appartment1);
        appartment2=findViewById(R.id.appartment2);
        appartment3=findViewById(R.id.appartment3);
        area1=findViewById(R.id.area1);
        area2=findViewById(R.id.area2);
        area3=findViewById(R.id.area3);
        avenue1=findViewById(R.id.avenue1);
        avenue2=findViewById(R.id.avenue2);
        avenue3=findViewById(R.id.avenue3);
        block1=findViewById(R.id.block1);
        block2=findViewById(R.id.block2);
        block3=findViewById(R.id.block3);
        building1=findViewById(R.id.building1);
        building2=findViewById(R.id.building2);
        building3=findViewById(R.id.building3);
        floor1=findViewById(R.id.floor1);
        floor2=findViewById(R.id.floor2);
        floor3=findViewById(R.id.floor3);
        street1=findViewById(R.id.street1);
        street2=findViewById(R.id.street2);
        street3=findViewById(R.id.street3);
        Bundle extras=getIntent().getExtras();
        String key=extras.getString("Key");
        place1=findViewById(R.id.one1);
        place2=findViewById(R.id.two1);
        place3=findViewById(R.id.three1);
    Toast.makeText(this, key, Toast.LENGTH_SHORT).show();
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dietplan-d8c38-default-rtdb.firebaseio.com/");
        databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(key)) {

                    Appartment1 = snapshot.child(key).child("Address").child("Place1").child("Appartment").getValue(String.class);
                    Appartment2 = snapshot.child(key).child("Address").child("Place2").child("Appartment").getValue(String.class);
                    Appartment3 = snapshot.child(key).child("Address").child("Place3").child("Appartment").getValue(String.class);
                     Area1 = snapshot.child(key).child("Address").child("Place1").child("Area").getValue(String.class);
                    Area2 = snapshot.child(key).child("Address").child("Place2").child("Area").getValue(String.class);
                    Area3 = snapshot.child(key).child("Address").child("Place3").child("Area").getValue(String.class);
                    Avenue1 = snapshot.child(key).child("Address").child("Place1").child("Avenue").getValue(String.class);
                    Avenue2 = snapshot.child(key).child("Address").child("Place2").child("Avenue").getValue(String.class);
                    Avenue3 = snapshot.child(key).child("Address").child("Place3").child("Avenue").getValue(String.class);
                     Block1 = snapshot.child(key).child("Address").child("Place1").child("Block").getValue(String.class);
                     Block2 = snapshot.child(key).child("Address").child("Place2").child("Block").getValue(String.class);
                     Block3  = snapshot.child(key).child("Address").child("Place3").child("Block").getValue(String.class);
                    Building1  = snapshot.child(key).child("Address").child("Place1").child("Building").getValue(String.class);
                    Building2  = snapshot.child(key).child("Address").child("Place2").child("Building").getValue(String.class);
                    Building3  = snapshot.child(key).child("Address").child("Place3").child("Building").getValue(String.class);
                     Floor1  = snapshot.child(key).child("Address").child("Place1").child("Floor").getValue(String.class);
                     Floor2  = snapshot.child(key).child("Address").child("Place2").child("Floor").getValue(String.class);
                   Floor3  = snapshot.child(key).child("Address").child("Place3").child("Floor").getValue(String.class);
                     Street1  = snapshot.child(key).child("Address").child("Place1").child("Street").getValue(String.class);
                   Street2  = snapshot.child(key).child("Address").child("Place2").child("Street").getValue(String.class);
                     Street3  = snapshot.child(key).child("Address").child("Place3").child("Street").getValue(String.class);

                    appartment1.setText(Appartment1);
                    appartment2.setText(Appartment2);
                    appartment3.setText(Appartment3);
                    area1.setText(Area1);
                    area2.setText(Area2);
                    area3.setText(Area3);
                    avenue1.setText(Avenue1);
                    avenue2.setText(Avenue2);
                    avenue3.setText(Avenue3);
                    block1.setText(Block1);
                    block2.setText(Block2);
                    block3.setText(Block3);
                    building1.setText(Building1);
                    building2.setText(Building2);
                    building3.setText(Building3);
                    floor1.setText(Floor1);
                    floor2.setText(Floor2);
                    floor3.setText(Floor3);
                    street1.setText(Street1);
                    street2.setText(Street2);
                    street3.setText(Street3);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
                bt.setOnClickListener(new View.OnClickListener() {
                    @Exclude
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SelectAddress.this, Appartment1, Toast.LENGTH_SHORT).show();
                        if(place1.isChecked()){
                            databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                   databaseReference.child("Profile").child(key).child("OrderPlaced1").child("Apartment").setValue(Appartment1);
                                    databaseReference.child("Profile").child(key).child("OrderPlaced1").child("Area").setValue(Area1);
                                    databaseReference.child("Profile").child(key).child("OrderPlaced1").child("Avenue").setValue(Avenue1);
                                    databaseReference.child("Profile").child(key).child("OrderPlaced1").child("Block").setValue(Block1);
                                    databaseReference.child("Profile").child(key).child("OrderPlaced1").child("Building").setValue(Appartment1);
                                    databaseReference.child("Profile").child(key).child("OrderPlaced1").child("Floor").setValue(Floor1);
                                    databaseReference.child("Profile").child(key).child("OrderPlaced1").child("Street").setValue(Street1);

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Toast.makeText(SelectAddress.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();

                                }
                            });
                        }
                        if(place2.isChecked()){
                            databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                databaseReference.child("Profile").child(key).child("OrderPlaced2").child("Apartment").setValue(Appartment2);
                                databaseReference.child("Profile").child(key).child("OrderPlaced2").child("Area").setValue(Area2);
                                    databaseReference.child("Profile").child(key).child("OrderPlaced2").child("Avenue").setValue(Avenue2);
                                    databaseReference.child("Profile").child(key).child("OrderPlaced2").child("Block").setValue(Block2);
                                    databaseReference.child("Profile").child(key).child("OrderPlaced2").child("Building").setValue(Appartment2);
                                    databaseReference.child("Profile").child(key).child("OrderPlaced2").child("Floor").setValue(Floor2);
                                    databaseReference.child("Profile").child(key).child("OrderPlaced2").child("Street").setValue(Street2);

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Toast.makeText(SelectAddress.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        if(place3.isChecked()){
                            databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                               databaseReference.child("Profile").child(key).child("OrderPlaced3").child("Apartment").setValue(Appartment3);
                               databaseReference.child("Profile").child(key).child("OrderPlaced3").child("Area").setValue(Area3);
                                databaseReference.child("Profile").child(key).child("OrderPlaced3").child("Avenue").setValue(Avenue3);
                                databaseReference.child("Profile").child(key).child("OrderPlaced3").child("Block").setValue(Block3);
                                databaseReference.child("Profile").child(key).child("OrderPlaced3").child("Building").setValue(Building3);
                                databaseReference.child("Profile").child(key).child("OrderPlaced3").child("Floor").setValue(Floor3);
                                databaseReference.child("Profile").child(key).child("OrderPlaced3").child("Street").setValue(Street3);

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(SelectAddress.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                            }
                        });}
                        Intent i=new Intent(getApplicationContext(),OrderPlaced.class);
                        i.putExtra("Key",key);
                        startActivity(i);
                    }
                });

    }
}
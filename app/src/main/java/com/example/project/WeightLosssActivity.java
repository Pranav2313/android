package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.project.Fragment.CheckoutFragment;
import com.example.project.models.MealPlanInfo.DurationsItem;
import com.example.project.models.MealPlanInfo.ProteinsItem;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class WeightLosssActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_losss);


        Fragment fr=new CheckoutFragment();
        loadFragment(fr);
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager manager=getSupportFragmentManager();
     FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.plandetails,fragment).addToBackStack("");
        transaction.commit();
   }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

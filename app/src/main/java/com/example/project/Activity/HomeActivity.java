package com.example.project.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.project.CalendarFragment;
import com.example.project.OnFragmentInteractionListener;
import com.example.project.R;
import com.example.project.Fragment.moreFragment;
import com.example.project.Fragment.MealsFragment;
import com.example.project.ui.Profile.ProfileFragment;
import com.example.project.Fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity implements OnFragmentInteractionListener,BottomNavigationView.OnNavigationItemSelectedListener {
String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        Bundle extras=getIntent().getExtras();
         key= extras.getString("Key");

        Toast.makeText(this, key, Toast.LENGTH_SHORT).show();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
       Fragment fragment = new HomeFragment().newInstance(key);
        loadFragment(fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_meals, R.id.navigation_profile, R.id.navigation_more)
                .build();


     navView.setOnNavigationItemSelectedListener(this);



    }


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack("");
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment().newInstance(key);
                loadFragment(fragment);
                return true;

            case R.id.navigation_calendar:
                fragment = new CalendarFragment().newInstance(key,"0");
                loadFragment(fragment);
                break;
            case R.id.navigation_profile:
                fragment = new ProfileFragment().newInstance(key);
//                        Bundle bundle=getIntent().getExtras();
//                        fragment.setArguments(bundle);
                loadFragment(fragment);
                break;
            case R.id.navigation_more:
                fragment = new moreFragment();
                loadFragment(fragment);
                break;
        }
        return false;

    }
}

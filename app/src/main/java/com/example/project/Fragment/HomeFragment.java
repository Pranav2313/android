package com.example.project.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.project.FourMealsWeightGain;
import com.example.project.FourMealsWeightLoss;
import com.example.project.R;
import com.example.project.ThreeMealsWeightGain;
import com.example.project.WeightLossActivity;
import com.example.project.ui.Profile.ProfileFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

private ImageSlider imageSlider;
ImageView one,two,up1,up2,back;
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
LinearLayout l1,l2;
TextView t1,t2,t3,t4;
    public static HomeFragment newInstance(String param1) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        //   args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            //  mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_home, container, false);

       Toast.makeText(getContext(), mParam1, Toast.LENGTH_SHORT).show();
        imageSlider=root.findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.i1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.i2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.i3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.i4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.i5, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.i6, ScaleTypes.FIT));
      imageSlider.setImageList(slideModels,ScaleTypes.FIT);

      one=root.findViewById(R.id.one);
      two=root.findViewById(R.id.two);
      l1=root.findViewById(R.id.hid1);
      l2=root.findViewById(R.id.hid2);
      t1=root.findViewById(R.id.t1);
      t2=root.findViewById(R.id.t2);
      t3=root.findViewById(R.id.t3);
      t4=root.findViewById(R.id.t4);
      up1=root.findViewById(R.id.up1);
      up2=root.findViewById(R.id.up2);

      one.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              l1.setVisibility(View.VISIBLE);
              t1.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      Intent i=new Intent(getActivity(),WeightLossActivity.class);
                      i.putExtra("Key",mParam1);
                      startActivity(i);
                  }
              });
              t2.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      Intent i=new Intent(getActivity(), FourMealsWeightLoss.class);
                      i.putExtra("Key",mParam1);
                      startActivity(i);
                  }
              });
              up1.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      l1.setVisibility(View.GONE);
                  }
              });
          }
      });

      two.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              l2.setVisibility(View.VISIBLE);
              t3.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      Intent i=new Intent(getActivity(), ThreeMealsWeightGain.class);
                      i.putExtra("Key",mParam1);
                      startActivity(i);
                  }
              });
              t4.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      Intent i=new Intent(getActivity(), FourMealsWeightGain.class);
                      i.putExtra("Key",mParam1);
                      startActivity(i);
                  }
              });
              up2.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      l2.setVisibility(View.GONE);
                  }
              });
          }
      });
        return root;
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack("");
        transaction.commit();
    }



}
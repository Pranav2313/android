package com.example.project.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project.Change_Password_Activity;
import com.example.project.OnFragmentInteractionListener;
import com.example.project.R;
import com.example.project.ui.Profile.ProfileFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileViewFragment extends Fragment {
 TextView name,email,gender,phone,alternatephone;
    DatabaseReference databaseReference;
    ImageView profileback;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
//    private static final String ARG_PARAM3 = "param3";
//    private static final String ARG_PARAM4 = "param4";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
//    private String mParam3;
//    private String mParam4;

    private OnFragmentInteractionListener mListener;

    public ProfileViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileViewFragment newInstance(String param1, String param2) {
        ProfileViewFragment fragment = new ProfileViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
//        args.putString(ARG_PARAM3, param3);
//        args.putString(ARG_PARAM4, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
//            mParam3 = getArguments().getString(ARG_PARAM3);
//            mParam4 = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profileview, container, false);
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dietplan-d8c38-default-rtdb.firebaseio.com/");

        name=view.findViewById(R.id.name);
       email=view.findViewById(R.id.email);
       gender=view.findViewById(R.id.gender);
       phone=view.findViewById(R.id.phone);
       alternatephone=view.findViewById(R.id.alternatePhone);
       profileback=view.findViewById(R.id.profileback);

       profileback.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Fragment fragment= moreFragment.newInstance("","");
               if (fragment !=null) {
                   FragmentTransaction ft = ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.nav_host_fragment, fragment);
                   ft.addToBackStack("");
                   ft.commit();
               }
           }
       });

        databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(mParam1)){
                    final String nameStr=snapshot.child(mParam1).child("Name").getValue(String.class);
                    final String emailStr=snapshot.child(mParam1).child("Email").getValue(String.class);
                    final String genderStr=snapshot.child(mParam1).child("Gender").getValue(String.class);
                    final String phoneStr=snapshot.child(mParam1).child("Phone").getValue(String.class);
                    final String AlternateStr=snapshot.child(mParam1).child("Alternatephone").getValue(String.class);

                    name.setText(nameStr);
                    email.setText(emailStr);
                    gender.setText(genderStr);
                    phone.setText(phoneStr);
                    alternatephone.setText(AlternateStr);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        textView_name.setText(mParam1);
//        textView_email.setText(mParam2);
//        textView_phone.setText(mParam3);
//        textView_gender.setText(mParam4);


//        profileviewback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fragment= new ProfileFragment();
//                if (fragment !=null) {
//                    FragmentTransaction ft = ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction();
//                    ft.replace(R.id.nav_host_fragment, fragment);
//                    ft.addToBackStack("ProfileFragment");
//                    ft.commit();
//                }
//            }
//        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}

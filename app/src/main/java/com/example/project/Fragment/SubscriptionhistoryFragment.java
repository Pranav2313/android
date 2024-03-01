package com.example.project.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project.OnFragmentInteractionListener;
import com.example.project.R;
import com.example.project.ui.Profile.ProfileFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SubscriptionhistoryFragment extends Fragment {
    ImageView subscriptionhistoryback;
    DatabaseReference databaseReference;
    TextView pD,carb,pro,start,last,carb2,carb3,carb4,pro2,pro3,pro4,start2,start3,start4,last2,last3,last4;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SubscriptionhistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubscriptionhistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SubscriptionhistoryFragment newInstance(String param1, String param2) {
        SubscriptionhistoryFragment fragment = new SubscriptionhistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_subscriptionhistory, container, false);
        subscriptionhistoryback=view.findViewById(R.id.subscriptionback);
        pD=view.findViewById(R.id.pd);
        carb=view.findViewById(R.id.carb);
        pro=view.findViewById(R.id.pro);
        start=view.findViewById(R.id.start1);
        last=view.findViewById(R.id.last1);

        carb2=view.findViewById(R.id.carb2);
        pro2=view.findViewById(R.id.pro2);
        start2=view.findViewById(R.id.start2);
        last2=view.findViewById(R.id.last2);

        carb3=view.findViewById(R.id.carb3);
        pro3=view.findViewById(R.id.pro3);
        start3=view.findViewById(R.id.start3);
        last3=view.findViewById(R.id.last3);

        carb4=view.findViewById(R.id.carb4);
        pro4=view.findViewById(R.id.pro4);
        start4=view.findViewById(R.id.start4);
        last4=view.findViewById(R.id.last4);

        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dietplan-d8c38-default-rtdb.firebaseio.com/");
        databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.hasChild(mParam1)){

                    final String getCarbohydrates=snapshot.child(mParam1).child("Order1").child("Carbohydrates").getValue(String.class);
                    final String getProtein=snapshot.child(mParam1).child("Order1").child("Protein").getValue(String.class);
                    final String getPlan=snapshot.child(mParam1).child("Order1").child("Plan").getValue(String.class);
                    final String StartDate=snapshot.child(mParam1).child("Order1").child("Start").getValue(String.class);
                    final String Last=snapshot.child(mParam1).child("Order1").child("Last").getValue(String.class);

                   // pD.setText(getPlan);
                    carb.setText(getCarbohydrates);
                    pro.setText(getProtein);
                    start.setText(StartDate);
                    last.setText(Last);
                    final String getCarbohydrates2=snapshot.child(mParam1).child("Order2").child("Carbohydrates").getValue(String.class);
                    final String getProtein2=snapshot.child(mParam1).child("Order2").child("Protein").getValue(String.class);
                    final String getPlan2=snapshot.child(mParam1).child("Order2").child("Plan").getValue(String.class);
                    final String StartDate2=snapshot.child(mParam1).child("Order2").child("Start").getValue(String.class);
                    final String Last2=snapshot.child(mParam1).child("Order2").child("Last").getValue(String.class);

                    // pD.setText(getPlan);
                    carb2.setText(getCarbohydrates2);
                    pro2.setText(getProtein2);
                    start2.setText(StartDate2);
                    last2.setText(Last2);
                    final String getCarbohydrates3=snapshot.child(mParam1).child("Order3").child("Carbohydrates").getValue(String.class);
                    final String getProtein3=snapshot.child(mParam1).child("Order3").child("Protein").getValue(String.class);
                    final String getPlan3=snapshot.child(mParam1).child("Order3").child("Plan").getValue(String.class);
                    final String StartDate3=snapshot.child(mParam1).child("Order3").child("Start").getValue(String.class);
                    final String Last3=snapshot.child(mParam1).child("Order3").child("Last").getValue(String.class);

                    // pD.setText(getPlan);
                    carb3.setText(getCarbohydrates3);
                    pro3.setText(getProtein3);
                    start3.setText(StartDate3);
                    last3.setText(Last3);

                    final String getCarbohydrates4=snapshot.child(mParam1).child("Order4").child("Carbohydrates").getValue(String.class);
                    final String getProtein4=snapshot.child(mParam1).child("Order4").child("Protein").getValue(String.class);
                    final String getPlan4=snapshot.child(mParam1).child("Order4").child("Plan").getValue(String.class);
                    final String StartDate4=snapshot.child(mParam1).child("Order4").child("Start").getValue(String.class);
                    final String Last4=snapshot.child(mParam1).child("Order4").child("Last").getValue(String.class);

                    // pD.setText(getPlan);
                    carb4.setText(getCarbohydrates4);
                    pro4.setText(getProtein4);
                    start4.setText(StartDate4);
                    last4.setText(Last4);
                }}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

                subscriptionhistoryback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Fragment fragment = new ProfileFragment();
                        if (fragment != null) {
                            FragmentTransaction ft = ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.nav_host_fragment, fragment);
                            ft.addToBackStack("");
                            ft.commit();
                        }
                    }
                });
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

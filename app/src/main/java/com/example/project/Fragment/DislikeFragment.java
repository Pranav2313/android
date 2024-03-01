package com.example.project.Fragment;

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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.project.OnFragmentInteractionListener;
import com.example.project.R;
import com.example.project.ui.Profile.ProfileFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DislikeFragment extends Fragment {
    ImageView dislikeback;
   CheckBox walnuts,mutton,chicken,beef,egg,fish,coconuts,mecademianuts;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    DatabaseReference databaseReference;
   Button save;
    private OnFragmentInteractionListener mListener;

    public DislikeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
    // * @param param2 Parameter 2.
     * @return A new instance of fragment DislikeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DislikeFragment newInstance(String param1) {
        DislikeFragment fragment = new DislikeFragment();
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
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dislike, container, false);
        dislikeback=view.findViewById(R.id.dislikesback);
        save=view.findViewById(R.id.save);
        walnuts=view.findViewById(R.id.walnuts);
        mutton=view.findViewById(R.id.mutton);
        chicken=view.findViewById(R.id.chicken);
        fish=view.findViewById(R.id.fish);
        egg=view.findViewById(R.id.egg);
        beef=view.findViewById(R.id.beef);
        coconuts=view.findViewById(R.id.coconuts);
        mecademianuts=view.findViewById(R.id.macadamianuts);

        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dietplan-d8c38-default-rtdb.firebaseio.com/");
        //Toast.makeText(getContext(), mParam1, Toast.LENGTH_SHORT).show();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(walnuts.isChecked()){
                    databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("Profile").child(mParam1).child("Dislikes").child("1").setValue("Walnuts");

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }else {
                    databaseReference.child("Profile").child(mParam1).child("Dislikes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild("Walnuts")){
                                databaseReference.child("Profile").child(mParam1).child("Dislikes").child("1").removeValue();

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }


                if (mutton.isChecked()){
                    databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("Profile").child(mParam1).child("Dislikes").child("2").setValue("Mutton");

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    databaseReference.child("Profile").child(mParam1).child("Dislikes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild("Mutton")){
                                databaseReference.child("Profile").child(mParam1).child("Dislikes").child("2").removeValue();

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
                if (chicken.isChecked()){
                    databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("Profile").child(mParam1).child("Dislikes").child("3").setValue("Chicken");

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }else {
                    databaseReference.child("Profile").child(mParam1).child("Dislikes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild("Chicken")){
                                databaseReference.child("Profile").child(mParam1).child("Dislikes").child("3").removeValue();

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
                if (egg.isChecked()){
                    databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("Profile").child(mParam1).child("Dislikes").child("4").setValue("Egg");

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }else {
                    databaseReference.child("Profile").child(mParam1).child("Dislikes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild("Egg")){
                                databaseReference.child("Profile").child(mParam1).child("Dislikes").child("4").removeValue();

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
                if (beef.isChecked()){
                    databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("Profile").child(mParam1).child("Dislikes").child("5").setValue("Beef");

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    databaseReference.child("Profile").child(mParam1).child("Dislikes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild("Beef")){
                                databaseReference.child("Profile").child(mParam1).child("Dislikes").child("5").removeValue();

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
                if (fish.isChecked()){
                    databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("Profile").child(mParam1).child("Dislikes").child("6").setValue("Fish");

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }else {
                    databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild("Fish")){
                                databaseReference.child("Profile").child(mParam1).child("Dislikes").child("7").removeValue();

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
                if (coconuts.isChecked()){
                    databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("Profile").child(mParam1).child("Dislikes").child("7").setValue("Coconuts");

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild("Coconuts")){
                                databaseReference.child("Profile").child(mParam1).child("Dislikes").child("7").removeValue();

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }


                if (mecademianuts.isChecked()){
                    databaseReference.child("Profile").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("Profile").child(mParam1).child("Dislikes").child("8").setValue("Macadamianuts");

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else {
                    databaseReference.child("Profile").child(mParam1).child("Dislikes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild("Macadamianuts")){
                                databaseReference.child("Profile").child(mParam1).child("Dislikes").child("8").removeValue();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }



            }
        });

        dislikeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment= new ProfileFragment();
                if (fragment !=null) {
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

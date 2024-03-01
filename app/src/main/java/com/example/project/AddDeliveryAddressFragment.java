package com.example.project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.project.Fragment.CheckoutFragment;
import com.example.project.Fragment.moreFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddDeliveryAddressFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    EditText earea,eavenue,eblock,estreet,ebuilding,efloor,eappartment;
    Button deliverybutton;
    ImageView back;
    String governorate,area,avenue,block,street,building,floor,appartment;
    String [] sgovernorate={"Place1","Place2","Place3"};
    DeliveryAddressModelClass deliveryAddressModelClass;

    boolean isAllFieldChecked=false;
    DatabaseReference databaseReference;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddDeliveryAddressFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddDeliveryAddressFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddDeliveryAddressFragment newInstance(String param1, String param2) {
        AddDeliveryAddressFragment fragment = new AddDeliveryAddressFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_delivery_address, container, false);
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dietplan-d8c38-default-rtdb.firebaseio.com/");

        earea=view.findViewById(R.id.earea);
        eavenue=view.findViewById(R.id.eavenue);
        eblock=view.findViewById(R.id.eblock);
        estreet=view.findViewById(R.id.estreet);
        ebuilding=view.findViewById(R.id.ebuilding);
        efloor=view.findViewById(R.id.efloor);
        eappartment=view.findViewById(R.id.eappartment);
        back=view.findViewById(R.id.adddelivery);
        Spinner spinner=view.findViewById(R.id.egovernorate);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter a=new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,sgovernorate);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(a);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr=new moreFragment();
               FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
               transaction.replace(R.id.plandetails,fr);
                transaction.commit();
            }
        });
        deliverybutton=view.findViewById(R.id.address_submit);
        deliverybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Fragment fr=new CheckoutFragment();
//                FragmentManager manager=getFragmentManager();
//                FragmentTransaction transaction=manager.beginTransaction();
//                transaction.replace(R.id.plandetails,fr);
//                transaction.commit();


                governorate=spinner.getSelectedItem().toString();
                area=earea.getText().toString();
                avenue=eavenue.getText().toString();
                block=eblock.getText().toString();
                street=estreet.getText().toString();
                building=ebuilding.getText().toString();
                floor=efloor.getText().toString();
                appartment=eappartment.getText().toString();

                if(!governorate.isEmpty() && !area.isEmpty() && !avenue.isEmpty() && !block.isEmpty() && !street.isEmpty() && !building.isEmpty() && !floor.isEmpty() && !appartment.isEmpty()){
                    getAddress();
                }
                    else{
                    earea.setError("This field is required");
                    eavenue.setError("This field is required");
                    eblock.setError("This field is required");
                    estreet.setError("This field is required");
                    ebuilding.setError("This field is required");
                    efloor.setError("This field is required");
                    eappartment.setError("This field is required");

                }
                databaseReference.child("Profile").child(mParam1).child("Address").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (governorate.equals("Place1")) {
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place1").child("Area").setValue(area);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place1").child("Avenue").setValue(avenue);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place1").child("Block").setValue(block);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place1").child("Street").setValue(street);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place1").child("Building").setValue(building);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place1").child("Floor").setValue(floor);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place1").child("Appartment").setValue(appartment);
                        }
                       else if (governorate.equals("Place2")) {
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place2").child("Area").setValue(area);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place2").child("Avenue").setValue(avenue);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place2").child("Block").setValue(block);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place2").child("Street").setValue(street);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place2").child("Building").setValue(building);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place2").child("Floor").setValue(floor);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place2").child("Appartment").setValue(appartment);
                        } else if (governorate.equals("Place3")) {
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place3").child("Area").setValue(area);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place3").child("Avenue").setValue(avenue);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place3").child("Block").setValue(block);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place3").child("Street").setValue(street);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place3").child("Building").setValue(building);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place3").child("Floor").setValue(floor);
                            databaseReference.child("Profile").child(mParam1).child("Address").child("Place3").child("Appartment").setValue(appartment);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                Toast.makeText(getContext(), "Address saved", Toast.LENGTH_SHORT).show();

                earea.setText("");
                eavenue.setText("");
                eblock.setText("");
                estreet.setText("");
                ebuilding.setText("");
                efloor.setText("");
                eappartment.setText("");

            }
        });
        return view;
    }

    private void getAddress() {
        Log.d("message1","getAddress function");

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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

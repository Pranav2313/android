package com.example.project.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.project.OnFragmentInteractionListener;
import com.example.project.R;


public class moreFragment extends Fragment {
    LinearLayout liaboutus,licontatus,liprivacy,literms;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public moreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment moreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static moreFragment newInstance(String param1, String param2) {
        moreFragment fragment = new moreFragment();
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
        View view= inflater.inflate(R.layout.fragment_more, container, false);
        liaboutus=view.findViewById(R.id.aboutus);
        licontatus=view.findViewById(R.id.contactus);
        liprivacy=view.findViewById(R.id.privacypolicy);
        literms=view.findViewById(R.id.termsandconditions);

        liaboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr= AboutUsFragment.newInstance(mParam1,mParam2);
                FragmentManager frmg=getFragmentManager();
                FragmentTransaction ft=frmg.beginTransaction();
                ft.replace(R.id.nav_host_fragment,fr).addToBackStack("");
                ft.commit();
            }
        });
        licontatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr= ContactUsFragment.newInstance(mParam1,mParam2);
                FragmentManager frmg=getFragmentManager();
                FragmentTransaction ft=frmg.beginTransaction();
                ft.replace(R.id.nav_host_fragment,fr).addToBackStack("");
                ft.commit();
            }
        });
        liprivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr= PrivacyPolicyFragment.newInstance(mParam1,mParam2);
                FragmentManager frmg=getFragmentManager();
                FragmentTransaction ft=frmg.beginTransaction().addToBackStack("");
                ft.replace(R.id.nav_host_fragment,fr);
                ft.commit();
            }
        });
        literms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr= TermsandConditionsFragment.newInstance(mParam1,mParam2);
                FragmentManager frmg=getFragmentManager();
                FragmentTransaction ft=frmg.beginTransaction().addToBackStack("");
                ft.replace(R.id.nav_host_fragment,fr);
                ft.commit();
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
   // public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
       // void onFragmentInteraction(Uri uri);
    //}
}

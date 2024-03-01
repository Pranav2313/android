package com.example.project.ui.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.project.Activity.SignInActivity;
import com.example.project.AddDeliveryAddressFragment;
import com.example.project.DeliveryAddressModelClass;
import com.example.project.Fragment.AboutUsFragment;
import com.example.project.Fragment.DislikeFragment;
import com.example.project.Fragment.ProfileViewFragment;
import com.example.project.OnFragmentInteractionListener;
import com.example.project.R;
import com.example.project.Fragment.SettingsFragment;
import com.example.project.Fragment.SubscriptionhistoryFragment;

public class ProfileFragment extends Fragment {
    LinearLayout limyprofile,lidislike,lisubscription,lisettings,lilogout;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    private ProfileViewModel profileViewModel;
    public static ProfileFragment newInstance(String param1) {
        ProfileFragment fragment = new ProfileFragment();
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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
//        notificationsViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

limyprofile=root.findViewById(R.id.profileid);
lidislike=root.findViewById(R.id.dislikeid);
lisubscription=root.findViewById(R.id.subscriptionhistoryid);
lisettings=root.findViewById(R.id.settingsid);
lilogout=root.findViewById(R.id.logoutid);


//        Intent intent=getActivity().getIntent();

//        Bundle bundle=getActivity().getIntent().getExtras();
//        String name3=bundle.getString("name2");
//        String email3=bundle.getString("email2");
//        String phone3=bundle.getString("phone2");
//        String gender3=bundle.getString("gender2");
        lilogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), SignInActivity.class);
                startActivity(i);

            }
        });

limyprofile.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Fragment fr= ProfileViewFragment.newInstance(mParam1,"");
//        fr.setArguments(bundle);
        FragmentManager frmg=getFragmentManager();
        FragmentTransaction ft=frmg.beginTransaction();
        ft.replace(R.id.nav_host_fragment,fr);
        ft.commit();
    }
});
lidislike.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Fragment fr=new DislikeFragment().newInstance(mParam1);
        FragmentManager frmg=getFragmentManager();
        FragmentTransaction ft=frmg.beginTransaction();
        ft.replace(R.id.nav_host_fragment,fr);
        ft.commit();
    }
});
lisubscription.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Fragment fr=new SubscriptionhistoryFragment().newInstance(mParam1,"");
        FragmentManager frmg=getFragmentManager();
        FragmentTransaction ft=frmg.beginTransaction();
        ft.replace(R.id.nav_host_fragment,fr).addToBackStack("");
        ft.commit();
    }
});
lisettings.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Fragment fr=new AddDeliveryAddressFragment().newInstance(mParam1,"");
        FragmentManager frmg=getFragmentManager();
        FragmentTransaction ft=frmg.beginTransaction();
        ft.replace(R.id.nav_host_fragment,fr);
        ft.commit();
    }
});

        return root;
    }
}
package com.example.project.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.project.Fragment.MealFragment;
import com.example.project.Fragment.SaladFragment;
import com.example.project.Fragment.SnacksFragment;

public class MyAdapter extends FragmentPagerAdapter {

//    private Context myContext;
    int totalTabs;
    String key;
    public MyAdapter( FragmentManager fm, int totalTabs,String key) {
        super(fm);
//        myContext=context;
        this.totalTabs=totalTabs;
        this.key=key;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                MealFragment mealFragment=new MealFragment().newInstance(key,"");
                return mealFragment;
            case 1:
                SaladFragment saladFragment=new SaladFragment().newInstance(key,"");
                return saladFragment;
            case 2:
                SnacksFragment snacksFragment=new SnacksFragment().newInstance(key,"");
                return snacksFragment;
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}

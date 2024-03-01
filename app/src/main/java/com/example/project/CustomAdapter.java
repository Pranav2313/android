package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int images[];
    String[] fruit;
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext,int[] flags, String[] fruit){
        this.context=applicationContext;
        this.images=flags;
        this.fruit=fruit;
        inflater=(LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view=inflater.inflate(R.layout.customspinner, null);
        ImageView icon=(ImageView)view.findViewById(R.id.imageview);
        TextView names=(TextView)view.findViewById(R.id.textview);
        icon.setImageResource(images[i]);
        names.setText(fruit[i]);
        return view;
    }
}

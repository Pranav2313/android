package com.example.project.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.WeightLossActivity;
import com.example.project.models.Home.MealCategoriesItem;
import com.example.project.models.Home.MealPlansItem;
import com.squareup.picasso.Picasso;


import java.net.ConnectException;
import java.util.List;

public class HomeMealsAdapter extends RecyclerView.Adapter<HomeMealsAdapter.ViewHolder>{
    private List<MealCategoriesItem> listdata;
    private AdapterListner listner;
    Context context;
    boolean arrow = true;
    HomeMealsSpinnerAdapter homeMealsAdapter;
    public interface AdapterListner{
        void onClick(List<MealPlansItem> user_id,int position);
    }
    public HomeMealsAdapter(Context context,List<MealCategoriesItem> recentModels, AdapterListner listner) {
        this.listdata = recentModels;
        this.listner = listner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.home_image_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        loadImage(listdata.get(position).getImage(), holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listner!=null){
                    listner.onClick(listdata.get(position).getMealPlans(),position);
                }
            }
        });
        holder.arrow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrow) {
                    holder.recyclerView.setVisibility(View.VISIBLE);
                    homeMealsAdapter = new HomeMealsSpinnerAdapter(listdata.get(position).getMealPlans(), new HomeMealsSpinnerAdapter.AdapterListner() {
                        @Override
                        public void onClick(List<MealPlansItem> user_id) {

                        }
                    });
                    holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                    holder.recyclerView.setAdapter(homeMealsAdapter);
                    arrow= false;
                }else {
                    holder.recyclerView.setVisibility(View.GONE);
                    arrow = true;
                }
            }
        });

    }
    @Override
    public int getItemCount() {
      return   listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public AppCompatImageView imageView;
        public RecyclerView recyclerView;
        RelativeLayout arrow_down;
        public ViewHolder(View itemView) {
            super(itemView);
            this.arrow_down = itemView.findViewById(R.id.arrow_down);
            this.imageView = itemView.findViewById(R.id.ivMeal);
            this.recyclerView = itemView.findViewById(R.id.recycler_view_spinner);
        }
    }

    private void loadImage(String userimage, ImageView imageView) {

        Picasso.get()
                .load(userimage)
//                .centerCrop()
                .into(imageView);
    }
}

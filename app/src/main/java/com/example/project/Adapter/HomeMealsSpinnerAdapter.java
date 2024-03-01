package com.example.project.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.models.Home.MealCategoriesItem;
import com.example.project.models.Home.MealPlansItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeMealsSpinnerAdapter extends RecyclerView.Adapter<HomeMealsSpinnerAdapter.ViewHolder>{
    private List<MealPlansItem> listdata;
    private AdapterListner listner;
    public interface AdapterListner{
        void onClick(List<MealPlansItem> user_id);
    }
    public HomeMealsSpinnerAdapter(List<MealPlansItem> recentModels, AdapterListner listner) {
        this.listdata = recentModels;
        this.listner = listner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_drop_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv1.setText(listdata.get(position).getName());
        holder.tv2.setText(listdata.get(position).getMealTypes());
    }
    @Override
    public int getItemCount() {
      return   listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv1,tv2;
        public ViewHolder(View itemView) {
            super(itemView);

            this.tv1 = itemView.findViewById(R.id.tv1);
            this.tv2 = itemView.findViewById(R.id.tv2);
        }
    }

    private void loadImage(String userimage, ImageView imageView) {

        Picasso.get()
                .load(userimage)
//                .centerCrop()
                .into(imageView);
    }
}

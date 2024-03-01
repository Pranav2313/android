package com.example.project.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.project.R;
import com.example.project.models.Home.BannersItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends PagerAdapter {
    Context mcontext;
    List<BannersItem>  item = new ArrayList<>();

    public ImageAdapter(Context context,  List< BannersItem> item){
        this.mcontext=context;
        this.item = item;
    }

    @Override
    public int getCount() {
        return sliderImageId.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((ImageView)object);
    }

    private int[] sliderImageId = new int[]{
R.drawable.homemeals1,R.drawable.homemelas3,R.drawable.homemeals4,R.drawable.homemeals5,R.drawable.homemeals2,
    };

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView=new ImageView(mcontext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setImageResource(sliderImageId[position]);
        loadImage(item.get(position).getImage(),imageView);

        ((ViewPager)container).addView(imageView,position);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView((ImageView)object);
    }
    private void loadImage(String userimage, ImageView imageView) {

        Picasso.get()
                .load(userimage)
                .into(imageView);
    }
}

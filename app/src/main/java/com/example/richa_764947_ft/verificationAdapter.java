package com.example.richa_764947_ft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class verificationAdapter extends BaseAdapter {
    Context context;
    ArrayList<Integer> trafficImages;

    public verificationAdapter(Context context,  ArrayList<Integer> trafficImages) {
        this.context = context;
        this.trafficImages = trafficImages;
    }

    @Override
    public int getCount() {
        return trafficImages.size();
    }

    @Override
    public Object getItem(int i) {
        return trafficImages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.grid_item,null);
        ImageView imageView = view.findViewById(R.id.image_Veri);
        imageView.setBackgroundResource(trafficImages.get(i));
        return view;
    }
}

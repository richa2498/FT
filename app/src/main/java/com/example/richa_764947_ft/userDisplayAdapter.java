package com.example.richa_764947_ft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class userDisplayAdapter extends ArrayAdapter {

    private List<UserData>users;
    private final LayoutInflater layoutInflater;
    private final int layoutResource;

    public userDisplayAdapter(@NonNull Context context, int resource, List<UserData> users) {
        super(context, resource);
        this.users = users;
        this.layoutInflater = LayoutInflater.from(context);
        this.layoutResource = resource;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if(view==null)
            view = layoutInflater.inflate(layoutResource,parent,false);
            TextView nameT = view.findViewById(R.id.nameL);
            TextView emailT = view.findViewById(R.id.emailL);
            TextView phoneT = view.findViewById(R.id.phoneL);
            ImageView icon = view.findViewById(R.id.imageL);
            nameT.setText(users.get(position).getName());
            emailT.setText(users.get(position).getEmail());
            phoneT.setText(users.get(position).getNumber());
            icon.setImageResource(users.get(position).getImage());


        return view;
    }
}

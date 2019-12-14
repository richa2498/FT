package com.example.richa_764947_ft;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class User_profile extends Fragment {


    public User_profile() {
        // Required empty public constructor
    }
    public void showUserDetail(int id){
        View view = getView();
        if(view!= null){
            TextView Uname = view.findViewById(R.id.user_name);
            TextView Uemail = view.findViewById(R.id.user_email);
            TextView Uphone = view.findViewById(R.id.user_phone);
            UserData ud = UserData.data.get(id);
            System.out.println(ud.getName());
            Uname.setText(ud.getName());
            Uemail.setText(ud.getEmail());
            Uphone.setText(ud.getNumber());
            ImageView iv = view.findViewById(R.id.user_image);
            iv.setImageResource(ud.getImage());
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_profile, container, false);
    }

}

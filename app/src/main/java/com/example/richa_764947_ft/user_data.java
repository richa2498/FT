package com.example.richa_764947_ft;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
interface Listener {
    void onItemClick(int id);
}
public class user_data extends Fragment {

    private Listener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    public user_data() {
        // Required empty public constructor
    }

    userDisplayAdapter ua;
    View view;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_data, container, false);



        return view;

    }

    @Override
    public void onStart() {
        super.onStart();

        Button add;
        ListView lv;
        lv = view.findViewById(R.id.view_data);
        if(!UserData.data.isEmpty()) {
//            String[] name = new String[UserData.data.size()];
//            for (int i = 0; i < name.length; i++) {
//                name[i] = UserData.data.get(i).getName();
//            }
//
//            ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, name);
//            lv.setAdapter(adapter);

            ua = new userDisplayAdapter(getContext(),R.layout.layout_list,UserData.data);
            lv.setAdapter(ua);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (listener != null)
                        listener.onItemClick(i);

                }
            });

        }
        add = view.findViewById(R.id.add_user);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), register_user.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }
}


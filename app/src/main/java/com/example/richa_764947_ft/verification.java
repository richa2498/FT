package com.example.richa_764947_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class verification extends AppCompatActivity {

    GridView gridView;
    ImageButton referesh;
    Button verify;
    CheckBox cb;
    UserData userData;


  ArrayList<Integer> trafficImages = new ArrayList<Integer>(){{
      add(R.drawable.img1);add(R.drawable.img2); add(R.drawable.img3);add(R.drawable.img4);
             add(R.drawable.img5);add(R.drawable.img6);add(R.drawable.img7);add(R.drawable.img8);add(R.drawable.img9);
  }};
  ArrayList<Integer> compareImage = new ArrayList<Integer>();

  ArrayList<Integer> lightsImages = new ArrayList<Integer>(){{
        add(R.drawable.img1);add(R.drawable.img2); add(R.drawable.img3);add(R.drawable.img4);
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        userData = (UserData) getIntent().getSerializableExtra("userData");
        cb = findViewById(R.id.checkBox);
        gridView = findViewById(R.id.imagesGrid);
        referesh = findViewById(R.id.refresh);
        verify = findViewById(R.id.verify);
      final verificationAdapter vf = new verificationAdapter(this,trafficImages);
        gridView.setAdapter(vf);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView i = view.findViewById(R.id.image_Veri);
                System.out.println(vf.getItem(position));
                i.setImageResource(R.drawable.checked);
                compareImage.add((Integer) vf.getItem(position));

            }
        });
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(lightsImages);
                System.out.println(compareImage);
                if (lightsImages.containsAll(compareImage) && cb.isChecked() == true)

                {
                    AlertDialog alertDialog = new AlertDialog.Builder(
                            verification.this).create();

                    alertDialog.setTitle("Registerd");
                    alertDialog.setMessage("You are Sucessfully Registered");
                    alertDialog.setIcon(R.drawable.mycheck);
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alertDialog.show();
                      //Toast.makeText(verification.this, "verification", Toast.LENGTH_SHORT).show();
                        UserData.data.add(userData);
                        System.out.println(UserData.data.get(0).getName());
                        //finish();

                }else {

                   // Toast.makeText(verification.this, "Faild verification Referesh And Try AGian", Toast.LENGTH_SHORT).show();
                    compareImage.clear();
                    gridView.setAdapter(vf);
                    Collections.shuffle(trafficImages);
                    gridView.deferNotifyDataSetChanged();

                }
            }
        });

        referesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compareImage.clear();
               gridView.setAdapter(vf);
                Collections.shuffle(trafficImages);
                gridView.deferNotifyDataSetChanged();

            }
        });

    }


}

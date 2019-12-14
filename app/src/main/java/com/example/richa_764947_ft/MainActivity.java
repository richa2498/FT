package com.example.richa_764947_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Listener {

    private boolean isTablet = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View deatailview = findViewById(R.id.user_profile);
        isTablet = deatailview != null && deatailview.getVisibility() == View.VISIBLE;


    }


    @Override
    public void onItemClick(int id) {
        if (isTablet) {

            User_profile userProfile = (User_profile) getSupportFragmentManager().findFragmentById(R.id.user_profile);
            userProfile.showUserDetail(id);
        } else {
            Intent intent = new Intent(this, Activity_user_profile.class);
            intent.putExtra(Activity_user_profile.TAG, id);
            startActivity(intent);
        }
    }
}
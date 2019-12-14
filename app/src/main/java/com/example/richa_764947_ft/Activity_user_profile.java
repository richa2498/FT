package com.example.richa_764947_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Activity_user_profile extends AppCompatActivity {

    public static final String TAG = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        User_profile userProfile = (User_profile) getSupportFragmentManager().findFragmentById(R.id.user_profile);
        Intent intent = getIntent();
        int id = intent.getExtras().getInt(TAG);
        userProfile.showUserDetail(id);

    }
}

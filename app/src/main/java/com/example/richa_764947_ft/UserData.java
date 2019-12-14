package com.example.richa_764947_ft;

import java.io.Serializable;
import java.util.ArrayList;


public class UserData implements Serializable {
    private String name;
    private String email;
    private String number;
    private int  image;

   public static int[] imageIcons = {R.drawable.icon01_10, R.drawable.icon01_02, R.drawable.icon01_03, R.drawable.icon01_04,
            R.drawable.icon01_05, R.drawable.icon01_06, R.drawable.icon01_07, R.drawable.icon01_08, R.drawable.icon01_09,
            R.drawable.icon01_10,R.drawable.icon01_11, R.drawable.icon01_12, R.drawable.icon01_13, R.drawable.icon01_14,
            R.drawable.icon01_15, R.drawable.icon01_16, R.drawable.icon01_17, R.drawable.icon01_18, R.drawable.icon01_19,
            R.drawable.icon01_20};


    public UserData(String name, String email, String number, int image) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public int getImage() {
        return image;
    }

    public static int[] getImageIcons() {
        return imageIcons;
    }

    public  static ArrayList<UserData> data = new ArrayList<>();
}

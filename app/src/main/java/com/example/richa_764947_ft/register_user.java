package com.example.richa_764947_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Random;

public class register_user extends AppCompatActivity {

    EditText nameM,emailM,phoneM;
    Button saveData;
    UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        nameM = findViewById(R.id.name);
        emailM = findViewById(R.id.email);
        phoneM = findViewById(R.id.phone);
        saveData = findViewById(R.id.register);



        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(nameM.getText().toString().isEmpty() || emailM.getText().toString().isEmpty() || phoneM.getText().toString().isEmpty() ){
                    //Toast.makeText(register_user.this,"all field must be filled",Toast.LENGTH_SHORT).show();
                   AlertDialog alertDialog = new AlertDialog.Builder(
                           register_user.this).create();
                   System.out.println("git hub not working");
//                   // Setting Dialog Title
                  alertDialog.setTitle("LOOK");

                   // Setting Dialog Message
                   alertDialog.setMessage("Fields are Empty");

                   // Setting Icon to Dialog
                   alertDialog.setIcon(R.drawable.checked);
                   alertDialog.show();
               }
               else {
                    Random ran = new Random();
                    int nxt = ran.nextInt(20);
                   System.out.println("Just to check git");
                    userData = new UserData(nameM.getText().toString(), emailM.getText().toString(), phoneM.getText().toString(),UserData.imageIcons[nxt]);
                    Intent intent = new Intent(register_user.this,verification.class);
                    intent.putExtra("userData", userData);
                    startActivity(intent);
                    finish();





                }
            }
        });
    }
}

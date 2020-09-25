package com.example.mad_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        logout=findViewById(R.id.b1);
         logout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent logout=new Intent(Admin.this,Login.class);
                 startActivity(logout);
             }
         });

    }

}
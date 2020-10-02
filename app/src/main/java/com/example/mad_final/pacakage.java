package com.example.mad_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class pacakage extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacakage);
        b1=(Button)findViewById(R.id.log);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lo= new Intent(pacakage.this,homepage.class);
                Toast.makeText(getApplicationContext(),"LOGOUT",Toast.LENGTH_SHORT).show();
                startActivity(lo);
            }
        });
    }
}
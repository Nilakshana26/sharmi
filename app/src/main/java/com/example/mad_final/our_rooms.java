package com.example.mad_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class our_rooms extends AppCompatActivity {
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_rooms);
        b1=(Button)findViewById(R.id.log);
        b2=(Button)findViewById(R.id.button4);


        b1=(Button)findViewById(R.id.log);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log =new Intent(our_rooms.this,homepage.class);
                Toast.makeText(getApplicationContext(),"LOGOUT",Toast.LENGTH_SHORT).show();
                startActivity(log);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bu=new Intent(our_rooms.this,booking.class);
                startActivity(bu);
            }
        });
    }
}
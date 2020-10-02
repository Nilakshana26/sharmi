package com.example.mad_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Admin extends AppCompatActivity {
    Button logout,room,pac,emp,book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admin );
        logout = findViewById( R.id.log );
        room = findViewById( R.id.empa );
        pac = findViewById( R.id.pac );
        emp = findViewById( R.id.emp );
        book = findViewById( R.id.book );


        pac.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pac = new Intent( Admin.this, Adminpackages.class );
                startActivity( pac );

            }
        } );

        logout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent( Admin.this, Login.class );
                Toast.makeText( getApplicationContext(), "LOGOUT", Toast.LENGTH_SHORT ).show();
                startActivity( logout );
            }
        } );
        room.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent room = new Intent( Admin.this, ADroom.class );
                startActivity( room );
            }
        } );
        emp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent employee = new Intent( Admin.this, AD_Employee.class );
                startActivity( employee );
            }
        } );

        book.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent employee = new Intent( Admin.this, Admin_booking.class );
                startActivity( employee );


            }
        } );

    }
}

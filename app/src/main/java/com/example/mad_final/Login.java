package com.example.mad_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1,reg;
    DatabaseHelper db;
    AwesomeValidation awesomeValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        awesomeValidation =new AwesomeValidation(ValidationStyle.BASIC);
        e1 = (EditText) findViewById(R.id.l1);
        e2 = (EditText) findViewById(R.id.l2);
        b1 = (Button) findViewById(R.id.button2);
        reg = (Button) findViewById(R.id.reg);
        db = new DatabaseHelper(this);
        awesomeValidation.addValidation(Login.this,R.id.l1, android.util.Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        awesomeValidation.addValidation(Login.this,R.id.l2,".{6}",R.string.invalid_password);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()) {

                    String email = e1.getText().toString();
                    String password = e2.getText().toString();
                    Boolean chkemailpass = db.emailpassword(email, password);
                    if (chkemailpass == true) {
                        Intent log = new Intent(Login.this, homepage.class);
                        startActivity(log);
                        if (email.equals("sk15@gmail.com") || password.equals("sharmi")) {
                            Intent adm = new Intent(Login.this, Admin.class);

                            startActivity(adm);
                        }
                        Toast.makeText(getApplicationContext(), "Sucessfully Login", Toast.LENGTH_SHORT).show();


                    } else
                        Toast.makeText(getApplicationContext(), " Login fail", Toast.LENGTH_SHORT).show();


                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg=new Intent(Login.this,MainActivity.class);
                Toast.makeText(getApplicationContext(),"VADALI REGISTRATION",Toast.LENGTH_SHORT).show();
                startActivity(reg);
            }
        });


    }
}
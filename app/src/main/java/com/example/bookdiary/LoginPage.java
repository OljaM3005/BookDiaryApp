package com.example.bookdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    EditText name, pass;
    Button signIn, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        name = findViewById(R.id.username_txt);
        pass = findViewById(R.id.password_txt);
        signIn = findViewById(R.id.sgnbtn);
        signUp = findViewById(R.id.sgnupbtn);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterPage.class);
                startActivity(i);

            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Explicit Intent
                Intent j = new Intent(getApplicationContext(), MainPage.class);
                startActivity(j);
                finish();
            }
        });



        LayoutInflater inflater = LayoutInflater.from(this);
        ConstraintLayout sublayout = (ConstraintLayout) inflater.inflate(R.layout.quit_btn, null);
        ConstraintLayout loginLayout = (ConstraintLayout) findViewById(R.id.loginlayout);
        loginLayout.addView(sublayout);

        Button quitBtn = sublayout.findViewById(R.id.quit_btn);
        quitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
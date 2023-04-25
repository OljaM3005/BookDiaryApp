package com.example.bookdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterPage extends AppCompatActivity {

    EditText user, pass, email, confirmPass;
    Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        user = findViewById(R.id.username_reg);
        pass = findViewById(R.id.password_reg);
        confirmPass = findViewById(R.id.confirmpass_reg);
        email = findViewById(R.id.email_reg);
        signUpBtn = findViewById(R.id.sgnUpBtn_reg);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Explicit Intent
                Intent j = new Intent(getApplicationContext(), MainPage.class);
                startActivity(j);
            }
        });



        LayoutInflater inflater = LayoutInflater.from(this);
        ConstraintLayout sublayout = (ConstraintLayout) inflater.inflate(R.layout.quit_btn, null);
        ConstraintLayout registerLayout = (ConstraintLayout) findViewById(R.id.registerlayout);
        registerLayout.addView(sublayout);

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
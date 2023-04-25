package com.example.bookdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Form extends AppCompatActivity {

    EditText title_input, author_input, pages_input;
    Button save_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        title_input = findViewById(R.id.title_id);
        author_input = findViewById(R.id.author_id);
        pages_input = findViewById(R.id.pages_id);
        save_btn = findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper my_db = new MyDatabaseHelper(Form.this);
                my_db.addBook(title_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                       Integer.valueOf(pages_input.getText().toString().trim()));
            }
        });
    }
}


package com.example.bookdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {


    ArrayList<My_book> books;
    Button add_book;
    EditText search;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        setupData();
        //generateData();


        add_book = findViewById(R.id.add_book);
        add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Form.class);
                startActivity(i);
            }
        });
    }
    public void setupData() {
        books = new ArrayList<My_book>();
        for (int i = 0; i<10; i++){
            books.add(new My_book("title" + i, "author" +i));
        }
    }

    //proveri problem!!!
    public void generateData() {
        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout mainLayout = findViewById(R.id.mainLayout);
        LinearLayout subLayout;
        EditText title, author;

        for (My_book b : books) {
            subLayout = (LinearLayout) inflater.inflate(R.layout.my_book, mainLayout, false);

            // books data
            title = subLayout.findViewById(R.id.bookTitleId);
            author = subLayout.findViewById(R.id.bookAuthorId);

            title.setText(b.getTitle());
            author.setText(b.getAuthor());

            mainLayout.addView(subLayout);

        }
    }
}

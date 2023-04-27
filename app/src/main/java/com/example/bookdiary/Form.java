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
import android.widget.Toast;

public class Form extends AppCompatActivity {

    Button save, quit;
    int indeks;
    My_book b;
    ArrayList<My_book> books = new ArrayList<My_book>();

    EditText title, author;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        save = findViewById(R.id.save_btn);
        quit = findViewById(R.id.give_up);

        books = (ArrayList<My_book>) getIntent().getSerializableExtra("title");
        indeks = getIntent().getIntExtra("indeks", -1);
        if (indeks == -1) {
            addBook();
        } else {
            editBook();
        }
    }
    public void addBook() {
        title = findViewById(R.id.bookTitleId);
        author = findViewById(R.id.bookAuthorId);
        save = findViewById(R.id.save_btn);
        quit = findViewById(R.id.give_up);


        b = new My_book();
        i = new Intent(Form.this, MainPage.class);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i.putExtra("books", books);
                startActivity(i);
                finish();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setTitle(title.getText().toString());
                b.setAuthor(author.getText().toString());
                ArrayList<My_book>books = new ArrayList<My_book>();
                books.add(b);
                Toast.makeText(Form.this, "ubaceno", Toast.LENGTH_SHORT).show();
                i.putExtra("books", books);
                startActivity(i);
                finish();
            }
        });

    }
    public void editBook(){
        title = findViewById(R.id.bookTitleId);
        author = findViewById(R.id.bookAuthorId);
        save = findViewById(R.id.save_btn);
        quit = findViewById(R.id.give_up);

        b = books.get(indeks);

        title.setText(b.getTitle());
        author.setText(b.getAuthor());
        i = new Intent(Form.this, MainPage.class);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i.putExtra("books", books);
                startActivity(i);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                books.get(indeks).setTitle(title.getText().toString());
                books.get(indeks).setAuthor(author.getText().toString());
                i.putExtra("books", books);
                startActivity(i);

            }
        });

    }


}

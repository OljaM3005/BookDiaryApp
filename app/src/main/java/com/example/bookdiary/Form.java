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

    private int indeks;
    private My_book k;
    private ArrayList<My_book> knjige;
    ConstraintLayout podlayout;
    EditText title, author, notes;
    Spinner genre, status;
    Intent i;
    Button save, quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        save = findViewById(R.id.save_btn);
        quit = findViewById(R.id.give_up);

        knjige = (ArrayList<My_book>)getIntent().getSerializableExtra("knjige");
        indeks = getIntent().getIntExtra("indeks", -1);
        if (indeks == -1){
            addBook();
        }
        else{
            editBook();
        }
    }

    public void addBook(){

        title = podlayout.findViewById(R.id.bookTitleId);
        author = podlayout.findViewById(R.id.bookAuthorId);
        save = podlayout.findViewById(R.id.save_btn);
        quit = podlayout.findViewById(R.id.give_up);

        k = new My_book("Title", "Author");
        i = new Intent(Form.this, MainPage.class);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("knjiga", knjige);
                startActivity(i);
                finish();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //k.setTitle(title.getText().toString());
                //k.setAuthor(author.getText().toString());
                knjige.add(k);
                i.putExtra("knjige", "knjige");
                startActivity(i);
                finish();
            }
        });
    }

    public void editBook(){
        title = podlayout.findViewById(R.id.bookTitleId);
        author = podlayout.findViewById(R.id.bookAuthorId);
        save = podlayout.findViewById(R.id.save_btn);
        quit = podlayout.findViewById(R.id.give_up);

        k = knjige.get(indeks);

        title.setText(k.getTitle());
        author.setText(k.getAuthor());

        i = new Intent(Form.this, MainPage.class);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("knjige", "knjige");
                startActivity(i);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // knjige.get(indeks).setTitle(title.getText().toString());
               // knjige.get(indeks).setAuthor(author.getText().toString());
                i.putExtra("knjige", knjige);
                startActivity(i);
            }
        });
    }
}


package com.example.bookdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

    //Context c;
    //LinearLayout mainLayout;
    //LinearLayout subLayout;
   // ArrayList<My_book> books;
    //ArrayList<My_book> shownBook;
    //Button add_book;
    //EditText search;

    //ArrayList<LinearLayout> children;

    RecyclerView recyclerView;
    FloatingActionButton add_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        recyclerView = findViewById(R.id.recyclerView);
        add_btn = findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, Form.class);
                startActivity(intent);

            }
        });


        //add_book = findViewById(R.id.add_book);
        //add_book.setOnClickListener(new View.OnClickListener() {
          //  @Override
          //  public void onClick(View view) {
               //Intent i = new Intent(getApplicationContext(), Form.class);
           //    //i.putExtra("books", books);
                //startActivity(i);
                //finish();
            }

       /* c = this;
        children = new ArrayList<>();
        books = (ArrayList<My_book>)getIntent().getSerializableExtra("title");
        if(books == null)
            setupData();
        generateData();
        setupSearch();
        setupButton();
    }
      */  //private void setupButton(){


    }/*
    private void setupSearch(){
        search = findViewById(R.id.inputSearch);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                shownBook = new ArrayList<My_book>();
                if(search.getText().equals("")){
                    shownBook = books;
                }
                else{
                    for(My_book b : books){
                        if(b.getTitle().contains(search.getText().toString())||
                                b.getAuthor().contains(search.getText().toString())
                                ){
                            shownBook.add(b);
                        }
                    }
                    clearAndGenerate();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    private void setupData(){
        books = new ArrayList<My_book>();
        for(int i = 0; i < 10; i++){
            books.add(new My_book("Title" + i, "Author" + i));
        }
    }
    private void clearAndGenerate(){

        for(My_book b : books){
            if(!shownBook.contains(b)){
                children.get(books.indexOf(b)).setVisibility(View.GONE);
            }
            else{
                children.get(books.indexOf(b)).setVisibility(View.VISIBLE);
            }
        }
    }


    //Prvobitno generisanje sadrzaja, ima dosta dupliranja koda
    private void generateData(){
        LayoutInflater inflater = LayoutInflater.from(this);
        mainLayout = findViewById(R.id.mainLayout);

        LinearLayout my_book;
        Button delBtn, editBtn;
        TextView title, author;

        boolean color = false;
        for(final My_book b : books){
            subLayout = (LinearLayout) inflater.inflate(R.layout.my_book,
                    mainLayout, false);
            children.add(subLayout);
            //podesavamo podatke za svaki kontakt

            title = subLayout.findViewById(R.id.naslov);
            author = subLayout.findViewById(R.id.autor);
            delBtn = subLayout.findViewById(R.id.del_btn);
            editBtn= subLayout.findViewById(R.id.edit_btn);
            my_book = subLayout.findViewById(R.id.my_book);

            my_book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainPage.this, Form.class);
                    i.putExtra("indeks", books.indexOf(b));
                    i.putExtra("books", books);
                    startActivity(i);
                    finish();
                }
            });

            delBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mainLayout.removeView(children.get(books.indexOf(b)));
                    children.remove(books.indexOf(b));
                    books.remove(b);
                }
            });

            title.setText(b.getTitle());
            author.setText(b.getAuthor());

            if(!color){
                color = true;
                subLayout.setBackgroundColor(Color.CYAN);
            }
            else{
                color = false;
                subLayout.setBackgroundColor(Color.GRAY);
            }
            mainLayout.addView(subLayout);
        }

    }*/


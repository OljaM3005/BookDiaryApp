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

    Button add_book;
    ConstraintLayout podlayout;
    LinearLayout glavnilayout;
    Context c;
    ArrayList<My_book> knjige;
    ArrayList<My_book> prikazaneKnjige;
    EditText search;
    ArrayList<ConstraintLayout> children;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        c = this;
        children = new ArrayList<>();
        knjige = (ArrayList<My_book>) getIntent().getSerializableExtra("knjige");
        if (knjige == null)
            setupData();
        generateData();
        setupSearch();
        setupButton();

        LayoutInflater inflater = LayoutInflater.from(this);
        ConstraintLayout sublayout = (ConstraintLayout) inflater.inflate(R.layout.quit_btn, null);
        ConstraintLayout mainpageLayout = (ConstraintLayout) findViewById(R.id.rootlayout);
        mainpageLayout.addView(sublayout);

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

    private void setupButton() {
        add_book = findViewById(R.id.add_book);
        add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Form.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void setupSearch() {
        search = findViewById(R.id.inputSearch);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                prikazaneKnjige = new ArrayList<My_book>();
                if (search.getText().equals("")) {
                    prikazaneKnjige = knjige;
                } else {
                    for (My_book k : knjige) {
                        if (k.getTitle().contains(search.getText().toString()) ||
                                k.getAuthor().contains(search.getText().toString())) {
                            prikazaneKnjige.add(k);
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

    private void setupData() {
        knjige = new ArrayList<My_book>();
        for (int i = 0; i < 100; i++) { //dodamo 100 knjiga
            knjige.add(new My_book("Title" + i, "Author" + i));
        }
    }

    private void clearAndGenerate() {

        for (My_book k : knjige) {
            if (!prikazaneKnjige.contains(k)) {
                children.get(knjige.indexOf(k)).setVisibility(View.GONE);
            } else {
                children.get(knjige.indexOf(k)).setVisibility(View.VISIBLE);
            }
        }
    }

    //Prvobitno generisanje sadrzaja, ima dosta dupliranja koda
    private void generateData() {
        LayoutInflater inflater = LayoutInflater.from(this);
        glavnilayout = findViewById(R.id.mainLayout);


        Button delBtn, editBtn;
        TextView title, author;


        boolean color = false;
        for (final My_book k : knjige) {
            podlayout = (ConstraintLayout) inflater.inflate(R.layout.my_book,
                    glavnilayout, false);
            children.add(podlayout);
            //tempChild = subLayout;
            //podesavamo podatke za svaki kontakt

            title = podlayout.findViewById(R.id.bookTitleId);
            author = podlayout.findViewById(R.id.bookAuthorId);
            delBtn = podlayout.findViewById(R.id.del_btn);
            editBtn = podlayout.findViewById(R.id.edit_btn);

            editBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), Form.class);
                    i.putExtra("indeks", knjige.indexOf(k));
                    i.putExtra("kontakti", knjige);
                    startActivity(i);
                    finish();
                }
            });

            delBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    glavnilayout.removeView(children.get(knjige.indexOf(k)));
                    children.remove(knjige.indexOf(k));
                    knjige.remove(k);
                }
            });
        }
    }
}
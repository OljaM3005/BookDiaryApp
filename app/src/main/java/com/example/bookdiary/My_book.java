package com.example.bookdiary;

import java.io.Serializable;

public class My_book implements Serializable {
        private String title;
        private String author;

    public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }


        public My_book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }


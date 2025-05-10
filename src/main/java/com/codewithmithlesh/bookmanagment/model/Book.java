package com.codewithmithlesh.bookmanagment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_books");
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String author;
    private int pages;

    public Book(){

    }

    public Book(String title, String author, int pages){
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

}

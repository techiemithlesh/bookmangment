package com.codewithmithlesh.bookmanagment.controller;

import com.codewithmithlesh.bookmanagment.model.Book;
import com.codewithmithlesh.bookmanagment.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {


    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add")
    public ResponseEntity<Book> addbooks(@RequestBody Book book){

        Book savedBook = bookRepository.save(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookRepository.findAll());
    }
}

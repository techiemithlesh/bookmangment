package com.codewithmithlesh.bookmanagment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping("/all")
    public String allBooks(){
        return "All books fetched successfully !";
    }
}

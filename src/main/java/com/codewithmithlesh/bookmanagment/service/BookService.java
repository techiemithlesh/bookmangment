package com.codewithmithlesh.bookmanagment.service;

import com.codewithmithlesh.bookmanagment.dto.BookRequestDTO;
import com.codewithmithlesh.bookmanagment.model.Book;

import java.util.List;

public interface BookService {
    Book savedBook (BookRequestDTO dto);
    List<Book> getAllBook();
    Book updateBook(Long id, BookRequestDTO dto);
    void deleteBook(Long id);
}
